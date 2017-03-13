<?php
$url = "https://data.montgomerycountymd.gov/api/views/icn6-v9z3/rows.csv";
set_time_limit(0);
//This is the file where we save the information
$fp = fopen ('/home/shared/Crime.csv', 'a+');

if (!$fp){
    echo "fuck0";
}
//Here is the file we are downloading, replace spaces with %20
$ch = curl_init(str_replace(" ","%20",$url));
curl_setopt($ch, CURLOPT_TIMEOUT, 50);

// write curl response to file
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
curl_setopt($ch, CURLOPT_FILE, $fp);
curl_setopt($ch, CURLOPT_FOLLOWLOCATION, true);
// get curl response
$contents = curl_exec($ch);
$curl_errno = curl_errno($ch);
$curl_error = curl_error($ch);

if ($curl_errno > 0)
{
    echo("CURL Error (".$curl_errno."): ".$curl_error);
}

curl_close($ch);
fwrite($fp,$contents);
fclose($fp);

?>