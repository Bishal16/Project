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
        $sql= "SELECT * from draft where id='$title'";
        $query =mysqli_query($connection,$sql);
        $row=mysqli_num_rows($query);
        $data = mysqli_fetch_assoc($query);
}elseif(!$title){
        $sql= "delete from draft where id='$delete'";
        $query =mysqli_query($connection,$sql);
        header("location:draft1.php");
}
    
mysqli_close($connection);

?>



<!DOCTYPE html>
<html lang="en">

<head>
    <title>Web Mailer</title>
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="inbox.css">

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
                <li><a  href="inbox.php">Inbox</a></li>
                <li><a href="sentbox.php">Sent</a></li>
                <li><a class="active" href="draft.php">Draft</a></li>
                <li ><a href="trash.php">Trash</a></li>
                <li ><a href="profile.php">Profile</a></li>
                <li ><a href="logout.php">Logout</a></li>

            </ul>
        </div>
        <div class="main_body">

            <div class="msg_header">
                <h2><?php echo $data['title'].'<br>'; ?></h2>
                To: <!---->
                <?php echo $data['r_email']; ?>
                <font style="margin-left:50%;">
                Time: <?php echo $data['date']." at ".$data['time']; ?>
                </font>
            </div>

            <div >
            <textarea class="massage" name="message"  > <?php echo $data['messege'];?></textarea>
                
                <br><br><br><br><br><br><br><br><br><br><br><br>
            </div>
            <!-- <form action="compose.php" method="post">                           
                <button class="button reply" type="submit" value=<?php echo $data['s_email'] ?> name="to_value"  formaction="compose.php">Reply</button>
            </form> -->
            <input type="submit" name="submit" value="send">
        </div>


    </div>
</body>

</html>
