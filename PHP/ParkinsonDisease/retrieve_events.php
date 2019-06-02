<?php
	include('config.php');

	$query="SELECT * FROM events";
	$values=null;
	$database=new DatabaseManager();
	$rows=$database->safeRetrieve($query,$values);
	$database->close();

	print(json_encode($rows));

?>