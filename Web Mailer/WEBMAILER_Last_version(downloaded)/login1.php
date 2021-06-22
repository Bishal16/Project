<?php
session_start();
?>


<?php

$server      = "localhost";
$password    = "hsq7B5DLJvjVMUKX";
$user        = "ourcuet_bishal";
$database    = "ourcuet_bishaldbms3";

$connection = mysqli_connect($server, $user, $password, $database);

if($_SERVER["REQUEST_METHOD"]=="POST")
{
    $pass=$_POST["password"];
    $email=$_POST["email"];
        
        $sql= "SELECT * FROM signup WHERE email = '$email'";
        $query = mysqli_query($connection,$sql);
        $num_rows= mysqli_num_rows($query);
        
        if($query)
        {
            $dpass= mysqli_fetch_array($query,MYSQLI_NUM);
            if($dpass[2]==$pass)
            {
                $_SESSION["user_mail"] = $email;
                header("Location:compose.php");
            }
            else
            {
                if($num_rows==0)
                {
                $error = 1;              //not signed up
                $msg= 'You need to sign up first<br><br>'.'<a href="signup.php">Sign Up</a>';
                }
                else
                {
                    $error = 2;          //incorrect password;
                    $msg= 'Incorrect Password<br>';
                }
            }
        }
        else
        {
            echo 'could not fatch data from database'.'<br>';
        }   
}


mysqli_close($connection);

?>


<!DOCTYPE html>
<html lang="en">
<html>

<head>
    <title>Web Mailer</title>
    <link rel="stylesheet" href="style_login.css">
</head>

<body>

    <div class="panel">
        <h1>Login</h1>
        <?php if($error==2){ ?>
        <form action="login1.php" method="post">
            <div id=box> <input type="email" name="email" placeholder="Email.."></div>
            <div id=box> <input type="password" name="password" placeholder="Password.."></div>
            <p style="text-align:center;">
            <font color="red" ><?php echo '<br>*'.$msg ?></font>
            </p>
            <div id=btn> <input id=btn type="submit" value="LOGIN"></div>
            <span><a href="signup.php">Don't have an account?Sign up</a> </span>
            <?php } ?>
        </form>
        
        <?php if($error==1){ ?>
        <p style="text-align : center;">
        <font color="red"><a href="signup.php">You don't have an account. sign up here</a></font></p>
        <?php } ?>
    </div>

</body>

</html>



