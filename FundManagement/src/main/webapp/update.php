<?php
    include "php/db_control.php";
    require 'php/somefun.php';
    session_start();

    $db = new db_control();
    $fun = new somefun();
    $user_id = $_SESSION["USER_ID"];    
    $tokan = $_SESSION["TOKAN"];
    $group_name = $_SESSION["GROUP_NAME"];
    $group_id = $_SESSION["GROUP_ID"];

    $data = $db->get_data("name","members","user_id","$user_id AND group_id = $group_id AND is_deleted = false","",1);


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
                                        <li><a href="addmember.php">Add</a></li>
                                        <li><a href="#">Update</a></li>
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
        <!--Page Header-->
                    <div class="container">
                    <div class="page-header text-center">
                        <h1>Update Member's</h1>                
                    </div>
                <!---end page header--->

        <!---search box--->
           <form>
            <div class="container">
                      <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search Member's">
                        <div class="input-group-btn">
                          <button class="btn btn-default" type="submit">
                            <i class="glyphicon glyphicon-search"></i>
                          </button>
                        </div>
                      </div>
                    </form><BR><BR>
                    </div>
        <!---search box--->

        <!--start data table-->
        <div class="container">

                            <div class="table-responsive">          
                              <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>No.</th>
                                        <th>Member Name</th>
                                        <th>Delete</th>
                                        <th>Edit</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <?php
                                $i=1;
                                while ($rows = mysql_fetch_array($data)):
                                    $Name = $rows['name'];
                                    echo "<tr>";
                                    echo "<td>$i</td>";
                                    echo "<td>$Name</td>";
                                    echo "<td><a href='#' class='btn btn-default btn-sm'>
                                        <span class='glyphicon glyphicon-remove'></span> Delete 
                                        </a></td>";
                                    echo "<td><a href='#' class='btn btn-default btn-sm'>
                                        <span class='glyphicon glyphicon-edit'></span> Edit 
                                        </a></td>";
                                    echo "</tr>";
                                    $i++;
                                 endwhile;

                                ?>
                                </tbody>
                              </table>
                              </div>
                            </div>
                </div>
                <!--end data table-->

                     </form>
                </div>






















            <!--Page Header-->
            <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
        <script src="js/myjs.js"></script>
    </body>
</html>