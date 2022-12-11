# Making-index-list with Binary Tree
- Đưa ra danh sách chỉ mục của file VanBan.txt(Hoặc 1 file văn bản nào đó, tôi cx ko bt nx)
- Chương trình đọc các từ trong file VanBan.txt(loại bỏ các dấu câu như: ':', '...', ';', ...) -> kiểm tra từ có nghĩa thông qua việc đối chiếu với các từ có trong file stopW.txt
- Chương trình sử dụng cây nhị phân để lưu các từ có nghĩa, số lần xuất hiện của từ đó
  + BnTree: chứa cây nhị phân của chương trình
  + LL: chưa danh sách liên kết gồm các từ vô nghĩa
  + LL3: chứa danh sách các dòng nơi từ tương ứng xuất hiện
- Từ khi được đưa vào cây nhị phân, nếu cây không có nút, thì từ đó sẽ trở thành nút gốc của cây, các từ thêm vào sau đó, nếu lớn hơn gốc (theo thứ tự từ điển) thì sẽ trở thành nút bên phải của gốc, nếu nhỏ hơn (theo thứ tự từ điển) thì sẽ thêm vào nút bên trái của gốc
- Nếu từ được thêm vào mà giống với từ của nút gốc, biến count trong nút gốc sẽ tăng thêm 1, dòng nơi từ đó xuất hiện sẽ được thêm vào Danh sách liên kết đặt trong nút gốc(xem class LL3 để biết thêm chi tiết)
