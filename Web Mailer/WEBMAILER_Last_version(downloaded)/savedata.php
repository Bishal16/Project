<?php
echo"jjjjjjjjj";
$db_name="ip";
$mySqlUserName="root";
$mySqlPassword="";
$serverName="localhost";

 $conn=mysqli_connect($serverName,$mySqlUserName,$mySqlPassword,$db_name);


if($conn)
{
    echo "connected";
}


if($_SERVER['REQUEST_METHOD']=='POST'){

$user_name=$_POST["user_name"];
$pass=$_POST["pass"];

$sql="INSERT INTO Login_info (user_name,password) 
        VALUES ('$user_name','$pass');" ;
    $result = mysqli_query($conn,$sql);
    if($result)
    {
        echo "inserted";
    }
    
} 

?>