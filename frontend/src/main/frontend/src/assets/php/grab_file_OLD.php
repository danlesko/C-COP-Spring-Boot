<?php

// $path = "Crime.csv";
 // $url = "https://data.montgomerycountymd.gov/resource/yc8a-5df8.csv";

$ch = curl_init();
$source = "https://data.montgomerycountymd.gov/api/views/icn6-v9z3/rows.csv";
curl_setopt($ch, CURLOPT_URL, $source);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
$data = curl_exec ($ch);
curl_close ($ch);

$destination = "/var/www/html/crimeData/Crime.csv";
$file = fopen($destination, "w+");
fputs($file, $data);
fclose($file);

echo "fuck you"

?>