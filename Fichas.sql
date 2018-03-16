host cls

drop table fichas;
drop table jugador;

CREATE OR REPLACE PACKAGE types
AS
     TYPE ref_cursor IS REF CURSOR;
END;
/
    CREATE TABLE Fichas(
		valor1 number(1),
        valor2 number(1),
        imagen varchar2(20),
        visible number(1),
        ubicacion number(1),
		constraint pkFicha primary key (valor1, valor2)
	);

    CREATE TABLE Jugador(
		id number(1),
        posicion number(3),
		constraint pkJugador primary key (id)
	);

-----------------Procedimientos-------------------------------------------
    create or replace function listarFicha
    RETURN Types.ref_cursor
        as
            ficha_cursor types.ref_cursor;
        begin
            open ficha_cursor for
                select * from Ficha;
                return ficha_cursor;
        end;
    /

    create or replace function consultarFichaUbicacion(laUbicacion number)
    RETURN Types.ref_cursor
        as
            ficha_cursor types.ref_cursor;
        begin
            open ficha_cursor for
                select * from Ficha where ubicacion = laUbicacion;
                return ficha_cursor;
        end;
    /

    create or replace procedure insertarJugador(id number, posicion number)
 	is
 	begin
            insert into Jugador values(id, posicion);
     end;
    /

    create or replace procedure actualizarFicha(elValor1 number, elValor2 number, laImagen varchar2, esVisible number, laUbicacion number)
 	is
 	begin
            update Ficha set valor1 = elValor1,
                             valor2 = elValor2, 
                             imagen = laImagen, 
                             visible = esVisible, 
                             ubicacion = laUbicacion,
            where valor1 = elValor1 and valor2 = elValor2;
     end;
    /
    
    insert into Fichas values(0,0,'..\imagenes\0-0.jpg',0,0);
    insert into Fichas values(0,1,'..\imagenes\0-1.jpg',0,0);
    insert into Fichas values(0,2,'..\imagenes\0-2.jpg',0,0);
    insert into Fichas values(0,3,'..\imagenes\0-3.jpg',0,0);
    insert into Fichas values(0,4,'..\imagenes\0-4.jpg',0,0);
    insert into Fichas values(0,5,'..\imagenes\0-5.jpg',0,0);
    insert into Fichas values(0,6,'..\imagenes\0-6.jpg',0,0);
    insert into Fichas values(1,1,'..\imagenes\1-1.jpg',0,0);
    insert into Fichas values(1,2,'..\imagenes\1-2.jpg',0,0);
    insert into Fichas values(1,3,'..\imagenes\1-3.jpg',0,0);
    insert into Fichas values(1,4,'..\imagenes\1-4.jpg',0,0);
    insert into Fichas values(1,5,'..\imagenes\1-5.jpg',0,0);
    insert into Fichas values(1,6,'..\imagenes\1-6.jpg',0,0);
    insert into Fichas values(2,3,'..\imagenes\2-3.jpg',0,0);
    insert into Fichas values(2,4,'..\imagenes\2-4.jpg',0,0);
    insert into Fichas values(2,5,'..\imagenes\2-5.jpg',0,0);
    insert into Fichas values(2,6,'..\imagenes\2-6.jpg',0,0);
    insert into Fichas values(3,3,'..\imagenes\3-3.jpg',0,0);
    insert into Fichas values(3,4,'..\imagenes\3-4.jpg',0,0);
    insert into Fichas values(3,5,'..\imagenes\3-5.jpg',0,0);
    insert into Fichas values(3,6,'..\imagenes\3-6.jpg',0,0);
    insert into Fichas values(4,4,'..\imagenes\4-4.jpg',0,0);
    insert into Fichas values(4,5,'..\imagenes\4-5.jpg',0,0);
    insert into Fichas values(4,6,'..\imagenes\4-6.jpg',0,0);
    insert into Fichas values(5,5,'..\imagenes\5-5.jpg',0,0);
    insert into Fichas values(5,6,'..\imagenes\5-6.jpg',0,0);
    insert into Fichas values(6,6,'..\imagenes\6-6.jpg',0,0);
