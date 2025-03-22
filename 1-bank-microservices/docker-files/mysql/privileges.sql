CREATE USER 'user1'@'%' IDENTIFIED BY 'user1';
GRANT CREATE, ALTER, DROP, INSERT, UPDATE, DELETE, SELECT, REFERENCES on *.* TO 'user1'@'%';
FLUSH PRIVILEGES;

CREATE DATABASE IF NOT EXISTS banking_core_service;
CREATE DATABASE IF NOT EXISTS banking_core_fund_transfer_service;
CREATE DATABASE IF NOT EXISTS banking_core_user_service;
CREATE DATABASE IF NOT EXISTS banking_core_utility_payment_service;