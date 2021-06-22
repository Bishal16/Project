
<?php

$nextstage=1;
$server      = "localhost";
$password    = "hsq7B5DLJvjVMUKX";
$user        = "ourcuet_bishal";
$database    = "ourcuet_bishaldbms3";
$connection = mysqli_connect($server, $user, $password, $database);

if($_SERVER["REQUEST_METHOD"]=="POST"){
    $dob=$_POST["dob"];
    $fname=$_POST["fname"];
    $lname=$_POST["lname"];
    $pass=$_POST["password"];
    $cpass=$_POST["cpassword"];
    $email=$_POST["email"];
    
    
    
    
    if($pass != $cpass){
        echo "*Password did not match"."<br>";
        $nextstage = 0;
    }
    if(!$pass){
        echo "*password required".'<br>';
        $nextstage = 0;
    }
    if(!$fname){
        echo '*first name required'.'<br>';
        $nextstage = 0;
    }
    if(!$lname){
        echo '*last name required'.'<br>';
        $nextstage = 0;
    }
    if(!$email){
        echo '*email required'.'<br>';
        $nextstage = 0;
    }
    if(!$dob){
        echo '*date of birth required'.'<br>';
        $nextstage = 0;
    }
    
    if($nextstage==1){
        
        $sql= "Insert into signup (fname,lname,password,email,dob) values('$fname','$lname','$pass','$email','$dob')";
        $iquery = mysqli_query($connection,$sql);
        
        if($iquery)
        {
            echo 'successful'.'<br>';
            header("Location: index.php");
        }
        else
        {
            echo 'failed to insert data'.'<br>';
        }
        
        
    }
}

mysqli_close($connection);

?>