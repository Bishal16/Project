<!DOCTYPE html>
<html lang="en">
<html>

<head>
    <title>Web Mailer</title>
    <link rel="stylesheet" href="style_signup.css">
</head>

<body>
<div id="header">
        <h3>Web Mailer</h3>
        <!-- <div class="ppp">   <?php echo $_SESSION["user_mail"] ; ?></div> -->
        <!-- <button>    Signup</button>
        <button>    About</button> -->

    </div>

    <div class="panel">
        <h1>Sign Up</h1>
        <form action="signup1.php" method ="post">
            <div id=box> <input type="text" placeholder="First name" name="fname"></div>
            <div id=box> <input type="text" placeholder="Last name" name="lname"></div>
            <div id=box> <input type="text" placeholder="mail : example@webmail.com" name="email"></div>
            <div id=box> <input type="text" placeholder="Date of birth : dd/mm/yy" name="dob"></div>

            <div id=box> <input type="password" placeholder="Password" name="password"></div>
            <div id=box> <input type="password" placeholder="Confirm password" name="cpassword"></div>
            <div id=btn> <input id="btn" type="submit" value="Sign Up"></div>
            <br>
            <br>
            <span><a href="login.php">already have an account?Log in</a> </span>
        </form>
    </div>

</body>

</html>
