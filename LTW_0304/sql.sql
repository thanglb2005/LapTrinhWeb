CREATE TABLE [User] (
    id INT IDENTITY PRIMARY KEY,
    email VARCHAR(100),
    username VARCHAR(50),
    fullname NVARCHAR(100),
    password VARCHAR(100),
    avatar VARCHAR(255),
    roleid INT,
    phone VARCHAR(20),
    createdDate DATE
);
CREATE TABLE Category (
    cate_id INT IDENTITY PRIMARY KEY,
    cate_name NVARCHAR(255) NOT NULL,
    icons NVARCHAR(255),
    user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES [User](id)
);


INSERT INTO [User] (username, password, roleid)
VALUES ('admin', '123', 1);

INSERT INTO Category (cate_name, icons, user_id)
VALUES 
(N'Sách CNTT', 'icon1.png', 1),
(N'Sách V?n h?c', 'icon2.png', 1);
