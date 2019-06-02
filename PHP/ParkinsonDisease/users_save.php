<?php
include('config.php');


$username=$_REQUEST['username'];
$email=$_REQUEST['email'];
$password=$_REQUEST['password'];
#$cpassword=$_REQUEST['cpassword'];
$name="";
$age="";
$gender="";
$phone="";
$diagnosis_type="";

$yr_of_diag="";
$medicine="";
$disease="";
$doc_name="";
$emergency_contact="";
$address="";
$sign_up="0";

	

	
	$insert_query="INSERT INTO users(username,email,password,name,age,gender,phone,diagnosis_type,disease,yr_of_diag,medicine,doc_name,emergency_contact,address,sign_up) 
				VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	$database=new DatabaseManager();
	

	$query="SELECT * FROM users WHERE username=?";
	$values=array($username);
	$database=new DatabaseManager();
	$rows=$database->safeRetrieve($query,$values);
	$total=count($rows);

	if($total>0 )
	{
		echo "Already";
	}
	else
{
		

		$values=array($username,$email,$password,$name,$age,$gender,$phone,$diagnosis_type,$disease,$yr_of_diag,$medicine,$doc_name,$emergency_contact,$address,$sign_up);

		$result=$database->fireSafeQuery($insert_query,$values);


		if($result=="Done")
		{
			echo 'Done';
		}
		else 
		{
			echo 'Error'.$result;
		}
}	
$database->close();

?>