package com.example.parkinson;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.parkinson.java.Config1;

import java.io.File;
import java.io.IOException;

public class Tips_Details extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips__details);

        setTitle("Notice Details");

        Initialized_Data();
        Button button = (Button)findViewById(R.id.view);
        //Button button3 = (Button)findViewById(R.id.corky3);
        // Register the onClick listener with the implementation above
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        // button.setOnClickListener((View.OnClickListener) this);
    }
    public void view_pdf(View v) {
System.out.println("bagad="+Config1.passenger.para2);
        String path= Config1.IP + "/uploads/" + Config1.passenger.para2;
        new DownloadFile().execute(path, Config1.passenger.para2);
        Toast.makeText(Tips_Details.this, "File Downloaded into uploads Folder", Toast.LENGTH_SHORT).show();
    }





    public void viewer(View v)
    {



        File file = new File(Environment.getExternalStorageDirectory().getAbsoluteFile()+"/uploads/"+Config1.passenger.para2);
        if (file.exists()) {
            System.out.println("sonal.............................. sonal");
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.fromFile(file), "application/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            //  intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            try {
                System.out.println("sonal.............................. sonal");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }else {
                    Toast.makeText(this,"No suitable app found!",Toast.LENGTH_SHORT).show();
                }
                // startActivity(intent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(Tips_Details.this, "NO Pdf Viewer", Toast.LENGTH_SHORT).show();
            }

        }


    }

    private class DownloadFile extends AsyncTask<String, Void, Void>{

        @Override
        protected Void doInBackground(String... strings) {
            String fileUrl = strings[0];   // -> http://maven.apache.org/maven-1.x/maven.pdf
            String fileName = strings[1];  // -> maven.pdf
            String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
            File folder = new File(extStorageDirectory, "uploads");
            folder.mkdir();

            File pdfFile = new File(folder, fileName);

            try{
                pdfFile.createNewFile();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            FileDownloader.downloadFile(fileUrl, pdfFile);
            return null;
        }
    }




/*webviewr
 /*
 WebView webview = new WebView(this);
            setContentView(webview);
            webview.getSettings().setJavaScriptEnabled(true);
            String path1=Environment.getExternalStorageDirectory() + "/studentrecord/" + Config1.passenger.para6;
            System.out.println("PDF Paths sonal="+path1);
            webview.loadUrl(path1);

    WebView webview = new WebView(this);
    setContentView(webview);
    webview.getSettings().setJavaScriptEnabled(true);
    String path=Config1.IP + "/uploads/" + Config1.passenger.para6;
    System.out.println("PDF Paths sonal="+path);
    webview.loadUrl(path);
    */
/*
    String path1="C:/xampp/htdocs/StudentRecord/uploads/"+edit_pdf;
    File pdfFile = new File(Environment.getExternalStorageDirectory(), path1);
    Intent objIntent = new Intent(Intent.ACTION_VIEW);
    objIntent.setDataAndType(path1, "application/pdf");
    objIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    startActivity(objIntent);

    /*
    try {
        if (pdfFile.exists()) {
            Uri path = Uri.fromFile(pdfFile);
            Intent objIntent = new Intent(Intent.ACTION_VIEW);
            objIntent.setDataAndType(path, "application/pdf");
            objIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(objIntent);
        } else {
            Toast.makeText(Notice_Detail.this, "File NotFound",
                    Toast.LENGTH_SHORT).show();
        }
    } catch (ActivityNotFoundException e) {
        Toast.makeText(Notice_Detail.this,
                "No Viewer Application Found", Toast.LENGTH_SHORT)
                .show();
    } catch (Exception e) {
        e.printStackTrace();
    }
*/


    // String d="C:/xampp/htdocs/StudentRecord/uploads/"+Config1.passenger.para6;
    // System.out.println("path="+d);
    // File file1 = null;
    // file1 = new File(d);







    /*
    File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() +"/Downloads/"+ Config1.passenger.para6);
    Toast.makeText(getApplicationContext(), file.toString() , Toast.LENGTH_LONG).show();
    if(file.exists()) {
        Intent target = new Intent(Intent.ACTION_VIEW);
        target.setDataAndType(Uri.fromFile(file), "application/pdf");
        target.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

        Intent intent = Intent.createChooser(target, "Open File");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            // Instruct the user to install a PDF reader here, or something
        }
    }
    else
        Toast.makeText(getApplicationContext(), "File path is incorrect." , Toast.LENGTH_LONG).show();
}


*/

    private void Initialized_Data() {





    }
/*
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

}
*/
}
