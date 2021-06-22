<?php
session_start();
?>



 <?php
 $server      = "localhost";
 $password    = "hsq7B5DLJvjVMUKX";
 $user        = "ourcuet_bishal";
 $database    = "ourcuet_bishaldbms3";

$current_user_mail=$_SESSION["user_mail"];
$connection = mysqli_connect($server, $user, $password, $database);
    
$sql= "SELECT * from signup where email='$current_user_mail'";
$query = mysqli_query($connection,$sql);
$data = mysqli_fetch_assoc($query);

mysqli_close($connection);

?> 



<!DOCTYPE html>
<html lang="en">

<head>
    <title><?php echo $data['fname']; echo" ".  $data['lname'] ?></title>
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="style_profile.css">
</head>

<body>

    <div id="header">
            <h1 >Web Mailer</h1>
            <button  title="Profile" class="profile_icon" onclick="window.location='profile.php'">  </button>     
            <div class="ppp">   <?php echo $_SESSION["user_mail"] ; ?></div>
    </div>

    <div id="main_div">
        <div class="sidebar">
            <ul>
                <li><a href="compose.php">Compose</a></li>
                <li><a href="inbox.php">Inbox</a></li>
                <li><a  href="sentbox.php">Sent</a></li>
                <li><a href="draft.php">Draft</a></li>
                <li><a href="trash.php">Trash</a></li>
                <li ><a class="active" href="profile.php">Profile</a></li>
                <li ><a href="logout.php">Logout</a></li>
            </ul>
        </div>
        <div class="main_body" id="inboxDiv">
            <div class="profile_div">
             <?php
                 $server      = "localhost";
                 $password    = "hsq7B5DLJvjVMUKX";
                 $user        = "ourcuet_bishal";
                 $database    = "ourcuet_bishaldbms3";

                $current_user_mail=$_SESSION["user_mail"];
                $connectionp = mysqli_connect($server, $user, $password, $database);
                    
                $sqlp= "SELECT * from additional_info where mail='$current_user_mail'";
                $queryp = mysqli_query($connectionp,$sqlp);
                $datap = mysqli_fetch_assoc($queryp);
                

                mysqli_close($connectionp);

                ?> 
                <?php if($datap['profile_pic']=="") {?>
                <img id="blah" class="profile_img" src="profile.png" alt="profile photo">
                <?php } ?>
                <?php if($datap['profile_pic']!="") {?>
                <img id="blah" class="profile_img" src="profile_photo/<?php echo$datap['profile_pic']?>" alt="profile photo">
                <?php } ?>
                <div id="profile_name"><?php echo $data['fname']; echo" ".  $data['lname'] ?></div>
                
            <?php
                if(isset($_POST["submit"]))
                {
                    $file=$_FILES["file"]["name"];
                    $tmp_name=$_FILES["file"]["tmp_name"];
                    $path="profile_photo/".$file;
                    $file1=explode(".",$file);
                    $ext=$file1[1];
                    $allowed=array("jpg","png","gif","jpeg");
                    if(in_array($ext,$allowed))
                    {
                        move_uploaded_file($tmp_name,$path);     
                        
                        $server      = "localhost";
                        $password    = "hsq7B5DLJvjVMUKX";
                        $user        = "ourcuet_bishal";
                        $database    = "ourcuet_bishaldbms3";

                        $current_user_mail=$_SESSION["user_mail"];
                        $connection = mysqli_connect($server, $user, $password, $database);
                            
                        $sql= "UPDATE additional_info SET profile_pic='$file' WHERE mail='$current_user_mail'";
                        $query = mysqli_query($connection,$sql);
                        

                        mysqli_close($connection);
                    }
                }
            ?>


            <form enctype="multipart/form-data"  method="post" >
                <label class="pp_update">
                    <input type="file" name="file" style="display: none" onchange="document.getElementById('blah').src = window.URL.createObjectURL(this.files[0])" >
                     Upload Photo <!-- style="display: none" -->
                </label>
                <input class="profile_save" type="submit" name="save" value="Save">
            </form>


            </div>
            <div class="profile_border" > <span id="pr_det">PROFILE DETAILS</span></div>

            <div class="profile_info">
                
                 
                    <table>
                        <tr>
                            <td>First Name</td>
                            <td><?php echo $data['fname']?></td>
                        </tr>
                        <tr>
                            <td>Last Name</td>
                            <td><?php echo $data['lname']?></td>
                        </tr>
                        <tr>
                            <td>Date of Birth</td>
                            <td><?php echo $data['dob']?></td>
                        </tr>
                        <tr>
                            <td>Sex</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>Phone No</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>Mail</td>
                            <td><?php echo $data['email']?></td>
                        </tr>
                        <tr>
                            <td>Bio</td>
                            <td></td>
                        </tr>
                    
                    </table>

                

            <br><br><br><br>

            </div>
                

            

        </div>

       
    </div>
</body>

</html>
