Hướng dẫn cài đặt các thư viện Vue 3 + Vite
Để bắt đầu phát triển ứng dụng với Vue 3 và Vite, bạn cần cài đặt các thư viện cần thiết. Hướng dẫn sau đây giúp bạn cấu hình môi trường với các thư viện sau:

axios: Thư viện để thực hiện các yêu cầu HTTP.
bootstrap: Thư viện giao diện người dùng.
date-fns: Xử lý và định dạng ngày giờ.
jwt-decode: Giải mã mã thông báo JWT.
vue-router: Quản lý điều hướng trong ứng dụng Vue.
---------
1. Khởi tạo dự án Vue 3 với Vite
Trước tiên, bạn cần tạo một dự án Vue 3 với Vite. Mở terminal và chạy lệnh sau:

Sao chép mã: npm create vite@latest my-vue-app --template vue

Sau khi khởi tạo thành công, chuyển vào thư mục dự án:

2. Cài đặt các thư viện cần thiết
Chạy lệnh sau để cài đặt các thư viện được liệt kê:

Sao chép mã: npm install axios bootstrap date-fns jwt-decode vue-router