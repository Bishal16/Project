<?php


$server      = "localhost";
$password    = "";
$user        = "root";
$database    = "mailservice";

$connection = mysqli_connect($server, $user, $password, $database);
if($_SERVER["REQUEST_METHOD"]=="POST"){
    
    $r_email= $_POST["to"];
    $title= $_POST["title"];
    $data= $_POST["massage"];
    $own_email= $_POST["from"];
    
    
    //own sentbox
        $sql1= "INSERT into sentbox (r_email, title, data,own_email) values('$r_email', '$title', '$data','$own_email')";
    
    //into other's inbox
        $sql2="INSERT into inbox (s_email,title, data,own_email) values('$own_email', '$title', '$data','r_email')";
    
        $query1 = mysqli_query($connection,$sql1);
    
    $query2 = mysqli_query($connection,$sql2);
        if($query1 && $query2){
            echo 'massage sent successfully';
        }   
}

mysqli_close($connection);

?>
