<?php
    require "vendor/SSO/SSO.php";
	
	$cas_path = dirname(__FILE__).'/vendor/CAS.php';
    SSO\SSO::setCASPath($cas_path);
	
	SSO\SSO::authenticate();
	$user = SSO\SSO::getUser();
?>