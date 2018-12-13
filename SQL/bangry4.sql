--대륙
CREATE TABLE continents
(
    continent_id      NUMBER          NOT NULL, 
    continent_name    VARCHAR2(50)    NOT NULL, 
    CONSTRAINT CONTINENTS_PK PRIMARY KEY (continent_id)
);

-- 지역
CREATE TABLE locations
(
    location_id            NUMBER          NOT NULL, 
    location_name          VARCHAR2(50)    NOT NULL, 
    location_state_name    VARCHAR2(50)    NULL, 
    continent_id           NUMBER          NOT NULL, 
    CONSTRAINT LOCATIONS_PK PRIMARY KEY (location_id)
);

COMMENT ON TABLE locations IS '지역';
COMMENT ON COLUMN locations.location_id IS '지역 고유 번호';
COMMENT ON COLUMN locations.location_name IS '지역명';
COMMENT ON COLUMN locations.location_state_name IS '주명';
COMMENT ON COLUMN locations.continent_id IS '대륙 고유 코드';

ALTER TABLE locations
    ADD CONSTRAINT FK_locations_continent_id_cont FOREIGN KEY (continent_id)
        REFERENCES continents (continent_id);


-- 부서
CREATE TABLE departments
(
    department_id      NUMBER          NOT NULL, 
    department_name    VARCHAR2(20)    NOT NULL, 
    location_id        NUMBER          NOT NULL, 
    CONSTRAINT DEPARTMENTS_PK PRIMARY KEY (department_id)
);

COMMENT ON TABLE departments IS '부서';
COMMENT ON COLUMN departments.department_id IS '부서 고유 번호';
COMMENT ON COLUMN departments.department_name IS '부서 명';
COMMENT ON COLUMN departments.location_id IS '이 부서가 위치한 지역 고유 번호';

ALTER TABLE departments
    ADD CONSTRAINT FK_departments_location_id_loc FOREIGN KEY (location_id)
        REFERENCES locations (location_id);



-- 커미션
CREATE TABLE commissions
(
    commission_id         NUMBER    NOT NULL, 
    commission_percent    NUMBER    NOT NULL, 
    CONSTRAINT COMMISSIONS_PK PRIMARY KEY (commission_id)
);

COMMENT ON TABLE commissions IS '커미션';
COMMENT ON COLUMN commissions.commission_id IS '커미션 고유 코드';
COMMENT ON COLUMN commissions.commission_percent IS '커미션 퍼센트';


-- 신용등급에 따른 고객 등급
CREATE TABLE customergrades
(
    customer_grade_id             NUMBER          NOT NULL, 
    customer_grade_name           VARCHAR2(20)    NOT NULL, 
    customer_grade_credit_rate    VARCHAR2(20)    NOT NULL, 
    customer_grade_promotion      NUMBER          NULL, 
    CONSTRAINT CUSTOMERGRADES_PK PRIMARY KEY (customer_grade_id)
);

COMMENT ON TABLE customergrades IS '고객등급';
COMMENT ON COLUMN customergrades.customer_grade_id IS '고객등급 고유 코드';
COMMENT ON COLUMN customergrades.customer_grade_name IS '고객등급명';
COMMENT ON COLUMN customergrades.customer_grade_credit_rate IS '신용등급';
COMMENT ON COLUMN customergrades.customer_grade_promotion IS '프로모션 가격';


-- 사원
CREATE TABLE employees
(
    employee_id                NUMBER           NOT NULL, 
    employee_first_name        VARCHAR2(40)     NOT NULL, 
    employee_last_name         VARCHAR2(40)     NOT NULL, 
    employee_system_user_id    VARCHAR2(40)     NOT NULL, 
    employee_hire_date         DATE             NOT NULL, 
    department_id              NUMBER           NULL, 
    employee_position          VARCHAR2(100)    NOT NULL, 
    employee_salary            NUMBER           NOT NULL, 
    commission_id              NUMBER           NULL, 
    employee_comment           VARCHAR2(200)    NULL, 
    CONSTRAINT EMPLOYEES_PK PRIMARY KEY (employee_id)
);

COMMENT ON TABLE employees IS '사원';
COMMENT ON COLUMN employees.employee_id IS '사원 고유 번호';
COMMENT ON COLUMN employees.commission_id IS '커미션 고유 코드';
COMMENT ON COLUMN employees.employee_comment IS '이 사원에 대한 의견';

ALTER TABLE employees
    ADD CONSTRAINT FK_employees_department_id_dep FOREIGN KEY (department_id)
        REFERENCES departments (department_id);

ALTER TABLE employees
    ADD CONSTRAINT FK_employees_commission_id_com FOREIGN KEY (commission_id)
        REFERENCES commissions (commission_id);


-- 고객
CREATE TABLE customers
(
    customer_id              NUMBER           NOT NULL, 
    customer_name            VARCHAR2(50)     NOT NULL, 
    customer_phone_number    VARCHAR2(50)     NULL, 
    customer_address         VARCHAR2(200)    NOT NULL, 
    customer_city_name       VARCHAR2(50)     NULL, 
    location_id              NUMBER           NOT NULL, 
    customer_postal_code     VARCHAR2(50)     NULL, 
    employee_id              NUMBER           NOT NULL, 
    customer_grade_id        NUMBER           NOT NULL, 
    customer_comment         VARCHAR2(200)    NULL, 
    customer_note            VARCHAR2(200)    NULL, 
    CONSTRAINT CUSTOMERS_PK PRIMARY KEY (customer_id)
);

COMMENT ON TABLE customers IS '고객';
COMMENT ON COLUMN customers.customer_id IS '고객번호';
COMMENT ON COLUMN customers.customer_postal_code IS '우편번호';
COMMENT ON COLUMN customers.employee_id IS '이 고객의 담당 영업 사원';
COMMENT ON COLUMN customers.customer_grade_id IS '고객등급 고유 코드';
COMMENT ON COLUMN customers.customer_comment IS '이 고객에 대한 회사의 의견';
COMMENT ON COLUMN customers.customer_note IS '비고';

ALTER TABLE customers
    ADD CONSTRAINT FK_customers_employee_id_emplo FOREIGN KEY (employee_id)
        REFERENCES employees (employee_id);

ALTER TABLE customers
    ADD CONSTRAINT FK_customers_location_id_locat FOREIGN KEY (location_id)
        REFERENCES locations (location_id);

ALTER TABLE customers
    ADD CONSTRAINT FK_customers_customer_grade_id FOREIGN KEY (customer_grade_id)
        REFERENCES customergrades (customer_grade_id);


-- 주문상태 
CREATE TABLE orderstates
(
    order_state_code           NUMBER           NOT NULL, 
    order_state_name           VARCHAR2(50)     NOT NULL, 
    order_state_description    VARCHAR2(200)    NULL, 
    CONSTRAINT ORDERSTATES_PK PRIMARY KEY (order_state_code)
);

COMMENT ON TABLE orderstates IS '주문 상태';
COMMENT ON COLUMN orderstates.order_state_code IS '주문 상태 코드';
COMMENT ON COLUMN orderstates.order_state_name IS '주문 상태명';




-- 제품
CREATE TABLE products
(
    product_id                   NUMBER           NOT NULL, 
    product_name                 VARCHAR2(50)     NOT NULL, 
    product_price                NUMBER           NOT NULL, 
    product_release_date         DATE             NOT NULL, 
    product_short_description    VARCHAR2(200)    NULL, 
    product_unit                 NUMBER           NOT NULL, 
    product_full_description     LONG             NULL, 
    product_picture              BLOB             NULL, 
    CONSTRAINT PRODUCTS_PK PRIMARY KEY (product_id)
);

COMMENT ON TABLE products IS '제품';
COMMENT ON COLUMN products.product_id IS '제품 고유 번호';
COMMENT ON COLUMN products.product_name IS '제품명';
COMMENT ON COLUMN products.product_price IS '단가';
COMMENT ON COLUMN products.product_release_date IS '출시일';
COMMENT ON COLUMN products.product_short_description IS '요약된 설명';
COMMENT ON COLUMN products.product_unit IS '판매 단위';
COMMENT ON COLUMN products.product_full_description IS '긴 설명';
COMMENT ON COLUMN products.product_picture IS '사진';


-- 주문
CREATE TABLE orders
(
    order_id            NUMBER    NOT NULL, 
    customer_id         NUMBER    NOT NULL, 
    order_date          DATE      NOT NULL, 
    order_state_code    NUMBER    NOT NULL, 
    CONSTRAINT ORDERS_PK PRIMARY KEY (order_id)
);

COMMENT ON TABLE orders IS '주문';
COMMENT ON COLUMN orders.order_id IS '주문 고유 번호';
COMMENT ON COLUMN orders.customer_id IS '고객번호';
COMMENT ON COLUMN orders.order_date IS '주문 날짜';
COMMENT ON COLUMN orders.order_state_code IS '주문 상태 코드';

ALTER TABLE orders
    ADD CONSTRAINT FK_orders_order_state_code_ord FOREIGN KEY (order_state_code)
        REFERENCES orderstates (order_state_code);

ALTER TABLE orders
    ADD CONSTRAINT FK_orders_customer_id_customer FOREIGN KEY (customer_id)
        REFERENCES customers (customer_id);

ALTER TABLE orders
MODIFY order_date DEFAULT sysdate;

-- 창고
CREATE TABLE warehouses
(
    warehouse_id              NUMBER           NOT NULL, 
    warehouse_name            VARCHAR2(50)     NULL, 
    location_id               NUMBER           NOT NULL, 
    warehouse_phone_number    VARCHAR2(50)     NULL, 
    warehouse_address         VARCHAR2(200)    NOT NULL, 
    warehouse_city_name       VARCHAR2(50)     NULL, 
    warehouse_postal_code     VARCHAR2(50)     NULL, 
    employee_id               NUMBER           NOT NULL, 
    CONSTRAINT WAREHOUSES_PK PRIMARY KEY (warehouse_id)
);

COMMENT ON TABLE warehouses IS '창고';
COMMENT ON COLUMN warehouses.warehouse_id IS '창고 고유 번호';
COMMENT ON COLUMN warehouses.warehouse_name IS '창고명';
COMMENT ON COLUMN warehouses.location_id IS '이 창고의 지역 고유 번호';
COMMENT ON COLUMN warehouses.warehouse_postal_code IS '우편번호';
COMMENT ON COLUMN warehouses.employee_id IS '담당 관리사원 고유 번호';

ALTER TABLE warehouses
    ADD CONSTRAINT FK_warehouses_employee_id_empl FOREIGN KEY (employee_id)
        REFERENCES employees (employee_id);

ALTER TABLE warehouses
    ADD CONSTRAINT FK_warehouses_location_id_loca FOREIGN KEY (location_id)
        REFERENCES locations (location_id);


-- 재고가 바닥난 이유 
CREATE TABLE stocklossreasons
(
    stock_loss_reason_id    NUMBER           NOT NULL, 
    stock_loss_reason       VARCHAR2(200)    NOT NULL, 
    CONSTRAINT STOCKLOSSREASONS_PK PRIMARY KEY (stock_loss_reason_id)
);

COMMENT ON TABLE stocklossreasons IS '재고 부족 사유';
COMMENT ON COLUMN stocklossreasons.stock_loss_reason_id IS '재고 부족 사유 고유 번호';
COMMENT ON COLUMN stocklossreasons.stock_loss_reason IS '이유 상세';


-- 재고
CREATE TABLE stocks
(
    warehouse_id            NUMBER    NOT NULL, 
    product_id              NUMBER    NOT NULL, 
    stock_available         NUMBER    NOT NULL, 
    stock_max               NUMBER    NOT NULL, 
    stock_loss_reason_id    NUMBER    NULL, 
    stock_reorder_date      DATE      NULL, 
    stock_restocked_date    DATE      NULL, 
    CONSTRAINT STOCKS_PK PRIMARY KEY (warehouse_id, product_id)
);

COMMENT ON TABLE stocks IS '재고';
COMMENT ON COLUMN stocks.warehouse_id IS '창고 고유 번호';
COMMENT ON COLUMN stocks.product_id IS '제품 고유 번호';
COMMENT ON COLUMN stocks.stock_available IS '재고량';
COMMENT ON COLUMN stocks.stock_max IS '최대 재고량';
COMMENT ON COLUMN stocks.stock_loss_reason_id IS '재고 부족사유 고유 번호';
COMMENT ON COLUMN stocks.stock_reorder_date IS '재주문 시점';
COMMENT ON COLUMN stocks.stock_restocked_date IS '재고가 다시 들어오는 날짜';

ALTER TABLE stocks
    ADD CONSTRAINT FK_stocks_stock_loss_reason_id FOREIGN KEY (stock_loss_reason_id)
        REFERENCES stocklossreasons (stock_loss_reason_id);

ALTER TABLE stocks
    ADD CONSTRAINT FK_stocks_product_id_products_ FOREIGN KEY (product_id)
        REFERENCES products (product_id);

ALTER TABLE stocks
    ADD CONSTRAINT FK_stocks_warehouse_id_warehou FOREIGN KEY (warehouse_id)
        REFERENCES warehouses (warehouse_id);


-- 주문항목
CREATE TABLE orderitems
(
    order_item_id          NUMBER     NOT NULL, 
    order_id               NUMBER     NOT NULL, 
    product_id             NUMBER     NOT NULL, 
    order_item_quantity    NUMBER     NOT NULL, 
    order_is_shipping      CHAR(1)    NULL, 
    warehouse_id           NUMBER     NOT NULL, 
    CONSTRAINT ORDERITEMS_PK PRIMARY KEY (order_item_id)
);

COMMENT ON TABLE orderitems IS '주문항목';
COMMENT ON COLUMN orderitems.order_item_id IS '주문 항목 고유 번호';
COMMENT ON COLUMN orderitems.order_id IS '주문 고유 번호';
COMMENT ON COLUMN orderitems.product_id IS '제품 고유 번호';
COMMENT ON COLUMN orderitems.order_item_quantity IS '주문 수량';
COMMENT ON COLUMN orderitems.order_is_shipping IS '선적 여부';
COMMENT ON COLUMN orderitems.warehouse_id IS '창고 고유 번호';

ALTER TABLE orderitems
    ADD CONSTRAINT FK_orderitems_order_id_orders_ FOREIGN KEY (order_id)
        REFERENCES orders (order_id);

ALTER TABLE orderitems
    ADD CONSTRAINT FK_orderitems_product_id_produ FOREIGN KEY (product_id)
        REFERENCES products (product_id);

ALTER TABLE orderitems
    ADD CONSTRAINT FK_orderitems_warehouse_id_sto FOREIGN KEY (warehouse_id)
        REFERENCES stocks (warehouse_id);

ALTER TABLE orderitems
      ADD CONSTRAINT orderitems_ck_quantity CHECK( order_item_quantity>0 );



-- 결제
CREATE TABLE payments
(
    payment_id               NUMBER          NOT NULL, 
    payment_complete_date    DATE            NULL, 
    payment_method           VARCHAR2(20)    NULL, 
    order_id                 NUMBER          NOT NULL, 
    CONSTRAINT PAYMENTS_PK PRIMARY KEY (payment_id)
);

COMMENT ON TABLE payments IS '결제';
COMMENT ON COLUMN payments.payment_id IS '결제 고유 번호';
COMMENT ON COLUMN payments.payment_complete_date IS '결제 완료일';
COMMENT ON COLUMN payments.payment_method IS '지불방법';
COMMENT ON COLUMN payments.order_id IS '주문 고유 번호';

ALTER TABLE payments
    ADD CONSTRAINT FK_payments_order_id_orders_or FOREIGN KEY (order_id)
        REFERENCES orders (order_id);
        
ALTER TABLE payments
MODIFY payment_complete_date DEFAULT sysdate;

-- 운송
CREATE TABLE transport
(
    transport_id          NUMBER    NOT NULL, 
    order_item_id        NUMBER    NOT NULL, 
    shipping_quantity    NUMBER    NULL, 
    shipping_date        DATE      NULL, 
    CONSTRAINT SHIPPINGS_PK PRIMARY KEY (transport_id)
);

COMMENT ON TABLE transport IS '운송';
COMMENT ON COLUMN transport.transport_id IS '운송 고유 번호';
COMMENT ON COLUMN transport.order_item_id IS '주문 항목 번호';
COMMENT ON COLUMN transport.shipping_quantity IS '선적 수량';
COMMENT ON COLUMN transport.shipping_date IS '선적 날짜';

ALTER TABLE transport
    ADD CONSTRAINT FK_transport_order_item_id_ord FOREIGN KEY (order_item_id)
        REFERENCES orderitems (order_item_id);        