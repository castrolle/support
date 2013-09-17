exec { 'apt-get update':                 
    command => '/usr/bin/apt-get update',
	path    => ['/bin', '/usr/bin'],     
}                                        


user { 'develpment':                   
      ensure     => present,           
      uid        => '507',             
      gid        => 'admin',           
      shell      => '/bin/zsh',        
      home       => '/home/develpment',
	  password   => 'develpment',        
      managehome => true,              
}                                      



class apache {					   
                                   
  package { 'apache2':             
    ensure => present,             
  }                                
                                   
  service { 'apache2':             
    ensure => running,             
    require => Package['apache2'], 
  }                                
                                   
  file { '/var/www':               
    ensure => link,                
    target => '/vagrant',          
    notify => Service['apache2'],  
    force  => true                 
  }                                
}                                  


include apache 
