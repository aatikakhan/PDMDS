<?php

	include('config.php');

	$username=$_REQUEST["username"];
	$password=$_REQUEST["password"];

	$query="SELECT * FROM users WHERE username=? AND password=?";
	$values=array($username,$password);
	$database=new DatabaseManager();
	$rows=$database->safeRetrieve($query,$values);
	$database->close();

	print(json_encode($rows));

?>
