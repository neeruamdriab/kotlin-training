--================================================================
-- create object HOTEL
--================================================================
CREATE OR REPLACE TYPE HOTEL as OBJECT(
    NAME VARCHAR2(20),
    ADDRESS VARCHAR2(20),
    STARS VARCHAR2(20),
    CONSTRUCTOR FUNCTION HOTEL(name VARCHAR2, address VARCHAR2, stars VARCHAR2) RETURN SELF AS RESULT,
    MEMBER FUNCTION get_name RETURN VARCHAR2(20),
    MEMBER FUNCTION get_address RETURN VARCHAR2(20),
    MEMBER FUNCTION get_stars RETURN VARCHAR2(20)
) INSTANTIABLE NOT FINAL;
--================================================================
-- create object DESTINATION
--================================================================
CREATE OR REPLACE TYPE DESTINATION AS OBJECT(
    AIRPORT VARCHAR2(20),
    HOTEL HOTEL,
    CONSTRUCTOR FUNCTION DESTINATION(airport VARCHAR2, hotel HOTEL) RETURN SELF AS RESULT,
    MEMBER FUNCTION get_hotel RETURN HOTEL
) INSTANTIABLE NOT  FINAL;
--================================================================
-- create object BOOKING
--================================================================
CREATE OR REPLACE TYPE BOOKING AS OBJECT(
    AMOUNT NUMBER,
    DESTINATION DESTINATION,
    CONSTRUCTOR FUNCTION DESTINATION(amount NUMBER, destination DESTINATION) RETURN SELF AS RESULT,
    MEMBER FUNCTION get_amount RETURN NUMBER,
    MEMBER FUNCTION get_destination RETURN DESTINATION
) INSTANTIABLE NOT  FINAL;
--================================================================
-- create object ACCOUNT
--================================================================
CREATE OR REPLACE TYPE ACCOUNT as OBJECT(
    USERNAME VARCHAR2(20),
    EMAIL VARCHAR2(20),
    CONSTRUCTOR FUNCTION ACCOUNT(username VARCHAR2, email VARCHAR2) RETURN SELF AS RESULT,
    MEMBER FUNCTION get_email RETURN VARCHAR2(20)
) INSTANTIABLE NOT  FINAL;
--================================================================
-- CHALLENGE 04
--================================================================
-- Rewrite the plsql below in Kotlin using kotlin nullability
-- For detais see: org.course.challenge04.NullSafetyExercise
-- and org.course.challenge04.NullSafetyExerciseTest
--================================================================

CREATE OR REPLACE FUNCTION confirmationMessage(
    account ACCOUNT, booking BOOKING
)
RETURN VARCHAR2(250)
IS
    l_email VARCHAR2(20);
    l_hotel_summary VARCHAR2(250);
    l_amount VARCHAR2(250);
    l_hotel HOTEL;
BEGIN
    IF booking is NOT NULL THEN
        IF booking.get_amount() is NULL THEN
            l_amount := 'Free';
        ELSE
            l_amount := TO_CHAR(booking.get_amount());
        END IF;

        IF booking.get_destination() IS NOT NULL AND booking.get_destination().get_hotel() IS NOT NULL THEN
            l_hotel := booking.get_destination().get_hotel();
            l_hotel_summary := COALESCE(l_hotel.get_name(), '') ||
                               ' ' ||
                               COALESCE(l_hotel.get_stars(), '') ||
                               'at ' ||
                               COALESCE(l_hotel.get_address(), '');

            IF account IS NOT NULL AND account.get_email() IS NOT NULL THEN
                l_email := account.get_email();
                RETURN createMessage(l_email, l_amount, l_hotel_summary);
            END IF;
        END IF;
    END IF;
    RETURN NULL;
END;

CREATE OR REPLACE FUNCTION createMessage(
    email VARCHAR2(20), amount VARCHAR2(20), hotel VARCHAR2(250)
)
RETURN VARCHAR2(250)
IS
BEGIN
   return 'Confirmation for: ' || email || 'amount: ' || amount || 'hotel: ' || hotel;
END;
