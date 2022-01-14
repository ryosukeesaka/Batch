

cd C:\Users\ryosuke.esaka.yu\Desktop\SpringBatchSample\demo\target
Java -Dspring.batch.job.names=mItemJob -jar demo.jar
set HOST=localhost
set PORT=5432
set USERID=postgres
set DBNAME=postgres
set PGPASSWORD=postgres
rem exec query
psql -h %HOST% -p %PORT% -U %USERID% -d %DBNAME% -c "COPY m_item2 FROM 'C:\temp\data.csv' with csv header encoding 'Shift-JIS'"
