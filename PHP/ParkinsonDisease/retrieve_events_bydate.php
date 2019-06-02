<?php
	include('config.php');

	$date1=$_REQUEST['date1'];

	$query="SELECT * FROM events WHERE date1=?";
	$values=array($date1);
	$database=new DatabaseManager();
	$rows=$database->safeRetrieve($query,$values);
	$database->close();

	print(json_encode($rows));

?>