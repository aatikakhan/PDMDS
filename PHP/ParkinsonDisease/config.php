<?php
 class DatabaseManager
{
	var $servername = "localhost";
	var $username = "root";
	var $password = "";
	var $database="parkinsondisease";
	public $conn='';
	
 
	public function __construct()
	{
		$servername = "localhost";
   	        $username = "root";
		$password = "";
		$database="parkinsondisease";
		 
		try
		{
			$this->conn = new PDO("mysql:host=$servername;dbname=$database", $username, $password);
						$this->conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
			
		}
		catch(PDOException $ex)
		{
			  echo "Connection failed: " . $ex->getMessage();
		}
	}
	
	public function fireQuery($query)
	{	$return_value="";
		try
		{
			$conn->exec($sql);
			$return_value="Done";
		}
		catch(PDOException $e)
		{
			//echo $e->getMessage();	
			$return_value=$e->getMessage();
		}
		
		return $return_value;
	}
	
	public function fireSafeQuery($query,$values)
	{
		$result='';
		
		try{
			
			$stmt = $this->conn->prepare($query);
			 
			$stmt->execute($values);
			 
			$result="Done";
		}
		catch(PDOException $ex)
		{
			$result=$ex->getMessage();
		}
		return $result;
	}
	
	public function safeRetrieve($query,$values)
	{
		$result='';
		
		try{
			
		 	$stmt = $this->conn->prepare($query);
			$stmt->execute($values);
			 
						$stmt->setFetchMode(PDO::FETCH_ASSOC);
			$result=$stmt->fetchAll();
		}
		catch(PDOException $ex)
		{
			$result=$ex->getMessage();
		}
		return $result;
	}
	
	public function close()
	{
		 $conn = null;
	}

	public function getTableIncrementValue($tablename,$table_id)
	{

		$table_rows=0;
	 
		$table_query="SELECT MAX(".$table_id.") AS ID FROM ".$tablename;
				$rows=$this->safeRetrieve($table_query,null);

		if(count($rows)>0)
		{
			 
			$table_rows=$rows[0]["ID"];

			  
		}	

		$table_rows=$table_rows+1;
		return $table_rows;
	}

}
?>