BEGIN

    FOR l IN
    (
        SELECT c.Name,l.EndDate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID=l.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE+30
    )
    LOOP

        DBMS_OUTPUT.PUT_LINE('Reminder : '
        ||l.Name||
        ' Loan Due Date : '
        ||l.EndDate);

    END LOOP;

END;
/