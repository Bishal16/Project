<?php
session_start();
?>


<?php

 $server      = "localhost";
 $password    = "hsq7B5DLJvjVMUKX";
 $user        = "ourcuet_bishal";
 $database    = "ourcuet_bishaldbms3";

$connection = mysqli_connect($server, $user, $password, $database);


$s_email=$_SESSION['user_mail'];
$r_email=$_POST['to'];
$title=$_POST['tittle'];
$messege=$_POST['message'];

$date=date("Y-m-d");
$time=date("h:i:sa");


        $sql= "Insert into draft (s_email,r_email,title,messege,date,time) Values ('$s_email','$r_email','$title','$messege','$date','$time')";
        $query =mysqli_query($connection,$sql);
        
        header("location:draft1.php");
    
mysqli_close($connection);

?>