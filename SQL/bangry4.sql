--���
CREATE TABLE continents
(
    continent_id      NUMBER          NOT NULL, 
    continent_name    VARCHAR2(50)    NOT NULL, 
    CONSTRAINT CONTINENTS_PK PRIMARY KEY (continent_id)
);

-- ����
CREATE TABLE locations
(
    location_id            NUMBER          NOT NULL, 
    location_name          VARCHAR2(50)    NOT NULL, 
    location_state_name    VARCHAR2(50)    NULL, 
    continent_id           NUMBER          NOT NULL, 
    CONSTRAINT LOCATIONS_PK PRIMARY KEY (location_id)
);

COMMENT ON TABLE locations IS '����';
COMMENT ON COLUMN locations.location_id IS '���� ���� ��ȣ';
COMMENT ON COLUMN locations.location_name IS '������';
COMMENT ON COLUMN locations.location_state_name IS '�ָ�';
COMMENT ON COLUMN locations.continent_id IS '��� ���� �ڵ�';

ALTER TABLE locations
    ADD CONSTRAINT FK_locations_continent_id_cont FOREIGN KEY (continent_id)
        REFERENCES continents (continent_id);


-- �μ�
CREATE TABLE departments
(
    department_id      NUMBER          NOT NULL, 
    department_name    VARCHAR2(20)    NOT NULL, 
    location_id        NUMBER          NOT NULL, 
    CONSTRAINT DEPARTMENTS_PK PRIMARY KEY (department_id)
);

COMMENT ON TABLE departments IS '�μ�';
COMMENT ON COLUMN departments.department_id IS '�μ� ���� ��ȣ';
COMMENT ON COLUMN departments.department_name IS '�μ� ��';
COMMENT ON COLUMN departments.location_id IS '�� �μ��� ��ġ�� ���� ���� ��ȣ';

ALTER TABLE departments
    ADD CONSTRAINT FK_departments_location_id_loc FOREIGN KEY (location_id)
        REFERENCES locations (location_id);



-- Ŀ�̼�
CREATE TABLE commissions
(
    commission_id         NUMBER    NOT NULL, 
    commission_percent    NUMBER    NOT NULL, 
    CONSTRAINT COMMISSIONS_PK PRIMARY KEY (commission_id)
);

COMMENT ON TABLE commissions IS 'Ŀ�̼�';
COMMENT ON COLUMN commissions.commission_id IS 'Ŀ�̼� ���� �ڵ�';
COMMENT ON COLUMN commissions.commission_percent IS 'Ŀ�̼� �ۼ�Ʈ';


-- �ſ��޿� ���� �� ���
CREATE TABLE customergrades
(
    customer_grade_id             NUMBER          NOT NULL, 
    customer_grade_name           VARCHAR2(20)    NOT NULL, 
    customer_grade_credit_rate    VARCHAR2(20)    NOT NULL, 
    customer_grade_promotion      NUMBER          NULL, 
    CONSTRAINT CUSTOMERGRADES_PK PRIMARY KEY (customer_grade_id)
);

COMMENT ON TABLE customergrades IS '�����';
COMMENT ON COLUMN customergrades.customer_grade_id IS '����� ���� �ڵ�';
COMMENT ON COLUMN customergrades.customer_grade_name IS '����޸�';
COMMENT ON COLUMN customergrades.customer_grade_credit_rate IS '�ſ���';
COMMENT ON COLUMN customergrades.customer_grade_promotion IS '���θ�� ����';


-- ���
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

COMMENT ON TABLE employees IS '���';
COMMENT ON COLUMN employees.employee_id IS '��� ���� ��ȣ';
COMMENT ON COLUMN employees.commission_id IS 'Ŀ�̼� ���� �ڵ�';
COMMENT ON COLUMN employees.employee_comment IS '�� ����� ���� �ǰ�';

ALTER TABLE employees
    ADD CONSTRAINT FK_employees_department_id_dep FOREIGN KEY (department_id)
        REFERENCES departments (department_id);

ALTER TABLE employees
    ADD CONSTRAINT FK_employees_commission_id_com FOREIGN KEY (commission_id)
        REFERENCES commissions (commission_id);


-- ��
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

COMMENT ON TABLE customers IS '��';
COMMENT ON COLUMN customers.customer_id IS '����ȣ';
COMMENT ON COLUMN customers.customer_postal_code IS '�����ȣ';
COMMENT ON COLUMN customers.employee_id IS '�� ���� ��� ���� ���';
COMMENT ON COLUMN customers.customer_grade_id IS '����� ���� �ڵ�';
COMMENT ON COLUMN customers.customer_comment IS '�� ���� ���� ȸ���� �ǰ�';
COMMENT ON COLUMN customers.customer_note IS '���';

ALTER TABLE customers
    ADD CONSTRAINT FK_customers_employee_id_emplo FOREIGN KEY (employee_id)
        REFERENCES employees (employee_id);

ALTER TABLE customers
    ADD CONSTRAINT FK_customers_location_id_locat FOREIGN KEY (location_id)
        REFERENCES locations (location_id);

ALTER TABLE customers
    ADD CONSTRAINT FK_customers_customer_grade_id FOREIGN KEY (customer_grade_id)
        REFERENCES customergrades (customer_grade_id);


-- �ֹ����� 
CREATE TABLE orderstates
(
    order_state_code           NUMBER           NOT NULL, 
    order_state_name           VARCHAR2(50)     NOT NULL, 
    order_state_description    VARCHAR2(200)    NULL, 
    CONSTRAINT ORDERSTATES_PK PRIMARY KEY (order_state_code)
);

COMMENT ON TABLE orderstates IS '�ֹ� ����';
COMMENT ON COLUMN orderstates.order_state_code IS '�ֹ� ���� �ڵ�';
COMMENT ON COLUMN orderstates.order_state_name IS '�ֹ� ���¸�';




-- ��ǰ
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

COMMENT ON TABLE products IS '��ǰ';
COMMENT ON COLUMN products.product_id IS '��ǰ ���� ��ȣ';
COMMENT ON COLUMN products.product_name IS '��ǰ��';
COMMENT ON COLUMN products.product_price IS '�ܰ�';
COMMENT ON COLUMN products.product_release_date IS '�����';
COMMENT ON COLUMN products.product_short_description IS '���� ����';
COMMENT ON COLUMN products.product_unit IS '�Ǹ� ����';
COMMENT ON COLUMN products.product_full_description IS '�� ����';
COMMENT ON COLUMN products.product_picture IS '����';


-- �ֹ�
CREATE TABLE orders
(
    order_id            NUMBER    NOT NULL, 
    customer_id         NUMBER    NOT NULL, 
    order_date          DATE      NOT NULL, 
    order_state_code    NUMBER    NOT NULL, 
    CONSTRAINT ORDERS_PK PRIMARY KEY (order_id)
);

COMMENT ON TABLE orders IS '�ֹ�';
COMMENT ON COLUMN orders.order_id IS '�ֹ� ���� ��ȣ';
COMMENT ON COLUMN orders.customer_id IS '����ȣ';
COMMENT ON COLUMN orders.order_date IS '�ֹ� ��¥';
COMMENT ON COLUMN orders.order_state_code IS '�ֹ� ���� �ڵ�';

ALTER TABLE orders
    ADD CONSTRAINT FK_orders_order_state_code_ord FOREIGN KEY (order_state_code)
        REFERENCES orderstates (order_state_code);

ALTER TABLE orders
    ADD CONSTRAINT FK_orders_customer_id_customer FOREIGN KEY (customer_id)
        REFERENCES customers (customer_id);

ALTER TABLE orders
MODIFY order_date DEFAULT sysdate;

-- â��
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

COMMENT ON TABLE warehouses IS 'â��';
COMMENT ON COLUMN warehouses.warehouse_id IS 'â�� ���� ��ȣ';
COMMENT ON COLUMN warehouses.warehouse_name IS 'â���';
COMMENT ON COLUMN warehouses.location_id IS '�� â���� ���� ���� ��ȣ';
COMMENT ON COLUMN warehouses.warehouse_postal_code IS '�����ȣ';
COMMENT ON COLUMN warehouses.employee_id IS '��� ������� ���� ��ȣ';

ALTER TABLE warehouses
    ADD CONSTRAINT FK_warehouses_employee_id_empl FOREIGN KEY (employee_id)
        REFERENCES employees (employee_id);

ALTER TABLE warehouses
    ADD CONSTRAINT FK_warehouses_location_id_loca FOREIGN KEY (location_id)
        REFERENCES locations (location_id);


-- ��� �ٴڳ� ���� 
CREATE TABLE stocklossreasons
(
    stock_loss_reason_id    NUMBER           NOT NULL, 
    stock_loss_reason       VARCHAR2(200)    NOT NULL, 
    CONSTRAINT STOCKLOSSREASONS_PK PRIMARY KEY (stock_loss_reason_id)
);

COMMENT ON TABLE stocklossreasons IS '��� ���� ����';
COMMENT ON COLUMN stocklossreasons.stock_loss_reason_id IS '��� ���� ���� ���� ��ȣ';
COMMENT ON COLUMN stocklossreasons.stock_loss_reason IS '���� ��';


-- ���
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

COMMENT ON TABLE stocks IS '���';
COMMENT ON COLUMN stocks.warehouse_id IS 'â�� ���� ��ȣ';
COMMENT ON COLUMN stocks.product_id IS '��ǰ ���� ��ȣ';
COMMENT ON COLUMN stocks.stock_available IS '���';
COMMENT ON COLUMN stocks.stock_max IS '�ִ� ���';
COMMENT ON COLUMN stocks.stock_loss_reason_id IS '��� �������� ���� ��ȣ';
COMMENT ON COLUMN stocks.stock_reorder_date IS '���ֹ� ����';
COMMENT ON COLUMN stocks.stock_restocked_date IS '��� �ٽ� ������ ��¥';

ALTER TABLE stocks
    ADD CONSTRAINT FK_stocks_stock_loss_reason_id FOREIGN KEY (stock_loss_reason_id)
        REFERENCES stocklossreasons (stock_loss_reason_id);

ALTER TABLE stocks
    ADD CONSTRAINT FK_stocks_product_id_products_ FOREIGN KEY (product_id)
        REFERENCES products (product_id);

ALTER TABLE stocks
    ADD CONSTRAINT FK_stocks_warehouse_id_warehou FOREIGN KEY (warehouse_id)
        REFERENCES warehouses (warehouse_id);


-- �ֹ��׸�
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

COMMENT ON TABLE orderitems IS '�ֹ��׸�';
COMMENT ON COLUMN orderitems.order_item_id IS '�ֹ� �׸� ���� ��ȣ';
COMMENT ON COLUMN orderitems.order_id IS '�ֹ� ���� ��ȣ';
COMMENT ON COLUMN orderitems.product_id IS '��ǰ ���� ��ȣ';
COMMENT ON COLUMN orderitems.order_item_quantity IS '�ֹ� ����';
COMMENT ON COLUMN orderitems.order_is_shipping IS '���� ����';
COMMENT ON COLUMN orderitems.warehouse_id IS 'â�� ���� ��ȣ';

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



-- ����
CREATE TABLE payments
(
    payment_id               NUMBER          NOT NULL, 
    payment_complete_date    DATE            NULL, 
    payment_method           VARCHAR2(20)    NULL, 
    order_id                 NUMBER          NOT NULL, 
    CONSTRAINT PAYMENTS_PK PRIMARY KEY (payment_id)
);

COMMENT ON TABLE payments IS '����';
COMMENT ON COLUMN payments.payment_id IS '���� ���� ��ȣ';
COMMENT ON COLUMN payments.payment_complete_date IS '���� �Ϸ���';
COMMENT ON COLUMN payments.payment_method IS '���ҹ��';
COMMENT ON COLUMN payments.order_id IS '�ֹ� ���� ��ȣ';

ALTER TABLE payments
    ADD CONSTRAINT FK_payments_order_id_orders_or FOREIGN KEY (order_id)
        REFERENCES orders (order_id);
        
ALTER TABLE payments
MODIFY payment_complete_date DEFAULT sysdate;

-- ���
CREATE TABLE transport
(
    transport_id          NUMBER    NOT NULL, 
    order_item_id        NUMBER    NOT NULL, 
    shipping_quantity    NUMBER    NULL, 
    shipping_date        DATE      NULL, 
    CONSTRAINT SHIPPINGS_PK PRIMARY KEY (transport_id)
);

COMMENT ON TABLE transport IS '���';
COMMENT ON COLUMN transport.transport_id IS '��� ���� ��ȣ';
COMMENT ON COLUMN transport.order_item_id IS '�ֹ� �׸� ��ȣ';
COMMENT ON COLUMN transport.shipping_quantity IS '���� ����';
COMMENT ON COLUMN transport.shipping_date IS '���� ��¥';

ALTER TABLE transport
    ADD CONSTRAINT FK_transport_order_item_id_ord FOREIGN KEY (order_item_id)
        REFERENCES orderitems (order_item_id);        