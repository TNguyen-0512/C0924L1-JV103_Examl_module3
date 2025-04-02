-- Xóa database nếu tồn tại và tạo mới
DROP DATABASE IF EXISTS dtb_exam_m3;
CREATE DATABASE dtb_exam_m3;
USE dtb_exam_m3;

-- Tạo bảng book
CREATE TABLE book (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    book_name NVARCHAR(255),
    author NVARCHAR(255),
    stock INT,
    `description` TEXT
);

-- Tạo bảng student
CREATE TABLE student (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    student_name NVARCHAR(50),
    class NVARCHAR(50)
);

-- Tạo bảng book_card
CREATE TABLE book_card (
    book_card_id INT AUTO_INCREMENT PRIMARY KEY,
    borrow_code VARCHAR(10) NOT NULL UNIQUE,
    book_id INT,
    student_id INT,
    status ENUM('Mượn', 'Trả sách') DEFAULT 'Mượn',
    borrow TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    return_date TIMESTAMP NULL DEFAULT NULL,
    FOREIGN KEY (book_id) REFERENCES book(book_id) ON DELETE CASCADE,
    FOREIGN KEY (student_id) REFERENCES student(student_id) ON DELETE CASCADE,
    CONSTRAINT chk_borrow_code CHECK (borrow_code REGEXP '^MS-[0-9]{4}$')
);

-- Thêm dữ liệu vào bảng book
INSERT INTO book (book_name, author, stock, description) VALUES
('Dế Mèn Phiêu Lưu Ký', 'Tô Hoài', 10, 'Truyện thiếu nhi nổi tiếng'),
('Harry Potter', 'J.K. Rowling', 5, 'Tiểu thuyết fantasy về phép thuật'),
('Sherlock Holmes', 'Arthur Conan Doyle', 8, 'Truyện trinh thám kinh điển'),
('7 viên ngọc rồng', 'Arthur Conan Doyle', 0, 'Truyện trinh thám kinh điển');

-- Thêm dữ liệu vào bảng student
INSERT INTO student (student_name, class) VALUES
('Nguyễn Văn A', '12A1'),
('Trần Thị B', '11B2'),
('Lê Văn C', '10C3');

-- Thêm dữ liệu vào bảng book_card
INSERT INTO book_card (borrow_code, book_id, student_id, status) VALUES
('MS-0001', 1, 1, 'Mượn'),
('MS-0002', 2, 2, 'Mượn'),
('MS-0003', 3, 3, 'Mượn');

-- Cập nhật trạng thái trả sách
UPDATE book_card SET status = 'Trả sách', return_date = NOW() WHERE borrow_code = 'MS-0001';
select * from book;
select * from student

