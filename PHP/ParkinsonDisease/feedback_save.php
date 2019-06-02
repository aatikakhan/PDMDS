<?php
include('config.php');



$username=$_REQUEST['username'];
$arising=$_REQUEST['arising'];
$speech=$_REQUEST['speech'];
$walking=$_REQUEST['walking'];
#$date="now()";

	

	$insert_query="INSERT INTO feedback(f_id,username,arising,speech,walking,date1,no) 
				VALUES(?,?,?,?,?,now(),?)";

 	$query="SELECT * FROM feedback WHERE username=?";
	$values=array($username);
	$database=new DatabaseManager();
	$rows=$database->safeRetrieve($query,$values);
	$total=count($rows);

	$no=$total+1;
	
		$f_id=$database->getTableIncrementValue("feedback","f_id");

		$values=array($f_id,$username,$arising,$speech,$walking,$no);

		$result=$database->fireSafeQuery($insert_query,$values);


		if($result=="Done")
		{
			echo 'Done';
		}
		else 
		{
			echo 'Error'.$result;
		}
	
$database->close();

?>



$db->query("INSERT INTO table(date) VALUES ('" . $db->escape(date('Y-m-d H:i:s')) . "'");