<?php
	include('config.php');

	$disease_name=$_REQUEST["disease_name"];

	$query="SELECT * FROM videos WHERE disease_name=?";
	$values=array($disease_name);
	$database=new DatabaseManager();
	$rows=$database->safeRetrieve($query,$values);
	$database->close();

	print(json_encode($rows));

?>