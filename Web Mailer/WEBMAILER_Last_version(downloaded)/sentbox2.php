<?php
session_start();
?>


<?php


$title = $_GET["qtitle"];
$delete= $_GET["delete"];


$server      = "localhost";
$password    = "hsq7B5DLJvjVMUKX";
$user        = "ourcuet_bishal";
$database    = "ourcuet_bishaldbms3";

$connection = mysqli_connect($server, $user, $password, $database);

if(!$delete){
        $sql= "SELECT * from inbox where id='$title'";
        $query =mysqli_query($connection,$sql);
        $row=mysqli_num_rows($query);
        $data = mysqli_fetch_assoc($query);
}
elseif(!$title)
{
    //trashing start
    $connection2 = mysqli_connect($server, $user, $password, $database);
    $sql2= "SELECT * from inbox where id='$delete'";
    $query2 =mysqli_query($connection2,$sql2);
    $data2 = mysqli_fetch_assoc($query2);
    $a=$data2["s_email"];
    $b=$data2["r_email"];
    $c=$data2["title"];
    $d=$data2["message"];
    $e=$data2["datee"];
    $f=$data2["timee"];
    $g=$data2["file"];

    $connection3 = mysqli_connect($server, $user, $password, $database);
    $sql3= "insert into trash (s_email,r_email,title,message,datee,timee,file) values('$a','$b','$c','$d','$e','$f','$g')";
    $iquery = mysqli_query($connection3,$sql3);
    //trashing end
    
    echo "<script type='text/javascript'>alert('');</script>";
        $sql= "delete from inbox where id='$delete'";
        $query =mysqli_query($connection,$sql);
         header("location:trash.php");
}
    
        
    
mysqli_close($connection);


?>



<!DOCTYPE html>
<html lang="en">

<head>
    <title>Web Mailer</title>
    <link rel="stylesheet" href="styles.css">
</head>

<body>

    <div id="header">
        <h1>Web Mailer</h1>
        <button  title="Profile" class="profile_icon" onclick="window.location='profile.php'">  </button>     
        <div class="ppp">
            <?php echo $_SESSION["user_mail"] ; ?>
        </div>
    </div>
    <div id="main_div">
        <div class="sidebar">
            <ul>
                <li><a href="compose.php">Compose</a></li>
                <li><a href="inbox.php">Inbox</a></li>
                <li><a class="active" href="sentbox.php">Sent</a></li>
                <li><a href="draft.php">Draft</a></li>
                <li ><a href="trash.php">Trash</a></li>
                <li ><a href="profile.php">Profile</a></li>
                <li ><a href="logout.php">Logout</a></li>

            </ul>
        </div>
        <div class="main_body">

            <div class="msg_header">
                <h2><?php echo $data['title'].'<br>'; ?></h2>
                To : <?php echo $data['r_email']; ?>
                <font style="margin-left:50%;">
                Time : <?php echo $data['datee']." at ".$data['timee']; ?>
                </font>
            </div>

            <div class="msg_body" ;>
                <?php echo $data['message']; ?>
                <br><br><br><br><br><br><br><br><br><br><br><br>
                <br><br><br><br><br><br><br><br><br><br><br><br>
            </div>

        </div>


    </div>
</body>

</html>
