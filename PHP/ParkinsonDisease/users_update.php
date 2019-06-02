<?php

include('config.php');
$username=$_REQUEST['username'];
$emergency_contact=$_REQUEST['emergency_contact'];

$phone=$_REQUEST['phone'];
$email=$_REQUEST['email'];
$password=$_REQUEST['password'];
$address=$_REQUEST['address'];

$insert_query="UPDATE users SET `phone`=?,`email`=?,`emergency_contact`=?,`address`=? ,`password`=? WHERE `username`=?";

 
$database=new DatabaseManager();
 
 $values=array($phone,$email,$emergency_contact,$address,$password,$username);

 $status=$database->fireSafeQuery($insert_query,$values);

	if($status=="Done")
    {
        echo "Done";
    }
    else
    {
        echo "Error : ".$status;
    }
    $database->close();

?>

