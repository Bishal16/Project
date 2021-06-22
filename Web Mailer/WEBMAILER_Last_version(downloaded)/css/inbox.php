<?php
session_start();
?>



<?php



$server      = "localhost";
$password    = "";
$user        = "root";
$database    = "mailservice";

$current_user_mail=$_SESSION["user_mail"];
$connection = mysqli_connect($server, $user, $password, $database);

    

        $sql= "SELECT * from inbox where r_email='$current_user_mail'";
        $query = mysqli_query($connection,$sql);
        $rownum = mysqli_num_rows($query);
        
        $arr=array();
        $id=array();
        $i=0;
        while($row = mysqli_fetch_assoc($query)) 
        {
            $arr[$i]=$row['title']; 
            $id[$i]=$row['id'];
            $i++;
        }
$i=0;

function delete(){
            echo "hello";
         $sql= "Delete from inbox where title='$arr[$i]'";
         $query = mysqli_query($connection,$sql);
         header("Location: inbox.php");
                             
}
    
mysqli_close($connection);

?>



<!DOCTYPE html>
<html lang="en">

<head>
    <title>Web Mailer</title>
    <link rel="stylesheet" href="styles.css">
    <!-- <link rel="stylesheet" href="styles1.css"> -->
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
                <li><a class="active" href="inbox.php">Inbox</a></li>
                <li><a href="sentbox.php">Sent</a></li>
                <li><a href="draft.php">Draft</a></li>
                <li ><a href="trash.php">Trash</a></li>
                <li ><a href="profile.php">Profile</a></li>
                <li><a href="logout.php">Logout</a></li>

            </ul>
        </div>
        <div class="main_body" id="inboxDiv">


            <?php while($rownum--){ ?>
            <div class="inbox">

                <a class="title" href="inbox2.php?qtitle=<?php echo $id[$i];?>&delete=0">
                    <?php echo $arr[$i]; ?>      
                </a>
               <button  title="delete" class="del_button" onclick="window.location='inbox2.php?qtitle=0&delete=<?php echo $id[$i];?>'">  </button>     
                    <?php     $i++; ?>


                
            </div>
            <?php } ?>
            <br><br><br><br><br><br><br><br><br><br><br><br>


            
        </div>


    </div>
</body>

</html>
