# Making-index-list
- Đưa ra danh sách chỉ mục của file VanBan.txt(Hoặc 1 file văn bản nào đó, tôi cx ko bt nx)
- Chương trình đọc các từ trong file VanBan.txt(loại bỏ các dấu câu như: ':', '...', ';', ...) -> kiểm tra từ có nghĩa thông qua việc đối chiếu với các từ có trong file stopW.txt
- Chương trình sử dụng 3 danh sách liên kết đơn để lưu các từ có nghĩa, các từ vô nghĩa và dòng nơi từ có nghĩa xuất hiện
  + LL: Danh sách các từ vô nghĩa đọc từ file stopW.txt
  + LL2: Danh sách các từ có nghĩa và số lần suất hiện của chúng
  + LL3: Danh sách các dòng nơi các từ tương ứng xuất hiện
- Mỗi khi thêm 1 từ vào danh sách, nếu từ đó đã tồn tại trong danh sách thì số lần suất hiện của từ(biến count) sẽ tăng lên, đồng thời dòng nơi từ xuất hiện sẽ được thêm vào danh sách
- Nếu 2 từ giống nhau xuất hiện trên cùng 1 dòng thì danh sách chỉ cập nhật 1 lần dòng đó
- Sau khi tạo ra danh sách chỉ mục của các từ, các từ trong mỗi node của DSLK sẽ đc so sánh và sắp xếp theo thứ tự từ điển thống qua vào phương thức sort
- Đã bổ sung 2 test case, có thể đưa ra test case riêng nếu muốn
  + testcase.txt chứa văn bản
  + stopCase.txt chứa danh sách các từ vô nghĩa
