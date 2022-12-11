# Making-index-list with Hash Table
- Đưa ra danh sách chỉ mục của file VanBan.txt(Hoặc 1 file văn bản nào đó, tôi cx ko bt nx)
- Chương trình đọc các từ trong file VanBan.txt(loại bỏ các dấu câu như: ':', '...', ';', ...) -> kiểm tra từ có nghĩa thông qua việc đối chiếu với các từ có trong file stopW.txt
- Chương trình sử dụng bảng băm (nói đơn giản là 1 mảng các danh sách liên kết đơn) để lưu các từ có nghĩa, số lần xuất hiện của từ đó
  + LL: danh sách liên kết gồm các từ vô nghĩa
  + LL2: danh sách liên kết gồm các từ có nghĩa, số lần xuất hiện và dòng nơi từ đó xuất hiện(1 dòng không xuất hiện 2 lần)
  + LL3: danh sách các dòng nơi từ tương ứng xuất hiện
  + HashM: chứa mảng các danh sách liên kết LL2 với chỉ số(HashCode/key) của mỗi từ được tính toán theo công thức: (Tổng từng chữ cái trong từ tính theo bảng mã ASCII) % 200
- Mỗi từ có trùng chỉ số sẽ được lưu vào node tiếp theo của danh sách liên kết với chỉ số tương ứng trên mảng
  + VD: "all" có chỉ số = 133 sẽ được lưu vào Hash[113], "far" cũng có chỉ số = 113 => "far" sẽ được lưu vào trở thành node tiếp theo của "all" trong Hash[113] 
- Vẫn chưa biết làm thế nào để sắp xếp chúng theo thứ tự từ điểm. Tuy nhiên, các từ trong cùng 1 danh sách liên kết sẽ được sắp xếp theo thứ tự từ điển thông qua method sort trong file LL2.
