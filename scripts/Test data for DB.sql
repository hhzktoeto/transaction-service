INSERT INTO transactions (type, user_id, category_id, date, amount, description)
SELECT 'EXPENSE',
       1,
       1,
       DATEADD('DAY', 1, CURRENT_DATE),
       ROUND(RAND() * 10000, 2),
       'Платёж за месяц ' + RAND()
FROM SYSTEM_RANGE(1, 100000);