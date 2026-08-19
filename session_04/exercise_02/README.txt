BÀI TẬP 2: QUẢN LÝ DỮ LIỆU (VOLUMES) VÀ DEPENDENCY GIỮA CÁC CONTAINER

1. Healthcheck

PostgreSQL sử dụng lệnh pg_isready để kiểm tra database đã sẵn sàng
nhận kết nối hay chưa.

Redis sử dụng lệnh redis-cli ping để kiểm tra Redis đã sẵn sàng
nhận kết nối hay chưa.

2. Depends_on

Backend sử dụng depends_on với condition: service_healthy.

Backend chỉ được khởi động sau khi PostgreSQL và Redis đều có trạng thái
healthy.

3. Volume

PostgreSQL sử dụng volume postgres_data và mount vào:

/var/lib/postgresql/data

Volume giúp dữ liệu PostgreSQL tồn tại độc lập với vòng đời của container.

Khi thực hiện:

docker compose down

các container bị xóa nhưng volume vẫn được giữ lại.

Khi thực hiện:

docker compose up -d

container PostgreSQL mới mount lại volume cũ nên dữ liệu vẫn còn.

4. Kết quả kiểm tra

- PostgreSQL: Up (healthy)
- Redis: Up (healthy)
- Backend: Up
- Backend khởi động sau khi PostgreSQL và Redis healthy.
- Dữ liệu StoreX Volume Test vẫn tồn tại sau khi down và up lại.