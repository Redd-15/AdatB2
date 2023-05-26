CREATE OR REPLACE PROCEDURE FUT AS
    F1 UTL_FILE.FILE_TYPE;
    SOR VARCHAR2(200);
begin
    F1 := UTL_FILE.FOPEN('DOP', 'minta.txt', 'R');
    
    BEGIN
    
        LOOP
            UTL_FILE.GET_LINE(F1, SOR, 100);
            DBMS_OUTPUT.PUT_LINE(SOR);
        
        END LOOP;
        
        EXCEPTION
            WHEN OTHERS THEN
                NULL;
    
    END;
    
    UTL_FILE.FCLOSE(F1);
end;


SET SERVEROUTPUT ON;

begin
FUT;
end;