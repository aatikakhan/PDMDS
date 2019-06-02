<?php

include('config.php');
$name=$_REQUEST['name'];
$age=$_REQUEST['age'];
$gender=$_REQUEST['gender'];
$phone=$_REQUEST['phone'];
$diagnosis_type=$_REQUEST['diagnosis_type'];

$yr_of_diag=$_REQUEST['yr_of_diag'];
$medicine=$_REQUEST['medicine'];
$disease=$_REQUEST['disease'];
$doc_name=$_REQUEST['doc_name'];
$emergency_contact=$_REQUEST['emergency_contact'];
$address=$_REQUEST['address'];
$sign_up=$_REQUEST['sign_up'];
$username=$_REQUEST['username'];


$insert_query="UPDATE users SET `name`=?,`age`=?,`gender`=?,`phone`=? ,`diagnosis_type`=? ,`yr_of_diag`=? ,`medicine`=? ,`disease`=? ,`doc_name`=? ,`emergency_contact`=? ,`address`=? ,`sign_up`=?  WHERE `username`=?";

 
$database=new DatabaseManager();
 
 $values=array($name,$age,$gender,$phone,$diagnosis_type,$yr_of_diag,$medicine,$disease,$doc_name,$emergency_contact,$address,$sign_up,$username);

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

