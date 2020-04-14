<?php
    session_start();
    $user_id = $_SESSION["USER_ID"];    
    $tokan = $_SESSION["TOKAN"];
    $group_name = $_SESSION["GROUP_NAME"];

?>

    <!DOCTYPE html>
    <html lang="en">
        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Add Member</title>
            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/styl.css" rel="stylesheet">
        </head>
        <body>
<!--start header -->
        <div class="container-fluid navbar-inverse" style=" color:white;">
        <!-- get the group name;-->
        <h1 class=" text-center text-white">
<?php
    echo strtoupper($group_name); 
 ?> 
        </h1>         
        </div>
<!--end header -->
        <div>
            <nav class=" navbar-inverse" style="font-size:15px;border-top:0.5px solid white;" id="navbar">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div>
                    <div class="collapse navbar-collapse" id="myNavbar">
                        <ul class="nav navbar-nav">
                            <li class=""><a href="dashboard.php">Home</a></li>
                                <li class="dropdown">
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="#"> Member <span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="update.php">Update</a></li>
                                        <li><a href="#">Delete</a></li>
                                        <li><a href="#">View</a></li>
                                    </ul>
                            </li>
                           <li class="dropdown">
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Savings <span class="caret"></span></a>
                                    <ul class="dropdown-menu ">
                                        <li><a href="addsavings.php">Add </a></li>
                                        <li><a href="#">View </a></li>
                                    </ul>
                            </li>
                            <li class="dropdown">
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Get Loan<span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Add EMI</a></li>
                                        <li><a href="#">View EMI</a></li>
                                        <li><a href="loand.php">New Loan</a></li>
                                    </ul>
                            </li>
                            <li class="dropdown">
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Total Collection<span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Total Fund</a></li>
                                        <li><a href="#">Total Loan</a></li>
                                    </ul>
                            </li>
                          </ul>
                          <ul class="nav navbar-nav navbar-right">
                            <li><a href="#"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
<div class="container">
            <!--Page Header-->
            <div class="page-header text-center" id="page-header">
                <h1>Add Member</h1>
            </div>
            <div>
                <form action="php/addmember.php" method="POST">              <!--new my name-->
                    
                     <div class="form-group row">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <label for="member">Member Name</label>
                            <input class="form-control" id="member" type="text" name="member_name" placeholder="Enter Member Name*" required>
                        </div>
                    </div>


                    <div class="form-group row">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <label for="address">Address</label>
                            <input class="form-control" id="address" type="text" name="address" placeholder="House No., Name, Landmark, Streat" required>
                        </div>                        
                    </div>

                    <div class="form-group row">
                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                            <label for="state">Select State</label>
                            <select class="form-control" id="state" name="state">
                                <option>Maharashtra</option>
                                <option>Gujrat</option>
                                <option>Kerla</option>
                                <option>Karnataka</option>
                            </select>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                            <label for="dist">Dist</label>
                            <select class="form-control" id="dist" name="dist">
                                <option>pune</option>
                                <option>nashik</option>
                                <option>nagpur</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group row">
                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                            <label for="taluka">Tal</label>
                             <select class="form-control" id="taluka" name="taluka">
                                <option>khed</option>
                                <option>ambegaon</option>
                                <option>junnar</option>
                            </select>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                            <label for="village">Village/ Locality</label>
                            <select class="form-control" id="village" name="village">
                                <option>ranjani</option>
                                <option>manchar</option>
                                <option>nagapur</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                            <label for="mobno">Mobile No</label>
                            <input class="form-control" id="mobno" type="text" name="mobile_number" placeholder="Enter Mobile No*" required>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                            <label for="email">Email ID</label>
                            <input class="form-control" id="email" type="text" name="email_id" placeholder="Enter Email-Id*" required>
                        </div>
                    </div>
                    <!--Date of Birth-->
                    <div class="form-group row">
                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                            <label for="dob">Date of Birth</label>
                            <input class="form-control" id="dob" type="date" name="dob" placeholder="date">
                        </div>

                        <!--Gender-->
                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                            <label for="gender">Gender</label>
                            <select class="form-control" id="gender" name="gender" placeholder="select gender">
                                <option>Male</option>
                                <option>Female</option>
                            </select>
                        </div>
                    </div>

                     <div class="form-group row">
                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                            <label for="id"></label>
                            <input class="form-control" id="id" type="number" name="gid" placeholder="Enter Id*" required>
                        </div>
                         <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                            <label for="shares">Share's</label>
                            <input class="form-control" id="shares" type="number" name="shares" placeholder="Enter How Many Shares*" required>
                        </div>
                    </div>
                       
                    <div class="form-group row">
                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                            <label for="adhar_card">Adhar Card Number</label>
                            <input class="form-control" id="adhar_card" type="text" name="adhar_card" placeholder="Enter Adhar Card Number*" required>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                            <label for="pan_card">Pan Card Number</label>
                            <input class="form-control" id="pan_card" type="text" name="pan_card" placeholder="Enter Pan Card Number*" required>
                        </div>
                    </div>
                     <div class="form-group row">
                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                            <label> </label>
                            <button type="submit" name="save" id="save" class="btn btn-primary btn-lg btn-block">Save</button>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                            <label> </label>
                            <button type="Reset" class="btn btn-info btn-lg btn-block">Reset</button>
                        </div>
                    </div>
                </form>
            </div>

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>

        <!-- js script -->
        <script src="js/myjs.js"></script>
        
    </body>
</html>