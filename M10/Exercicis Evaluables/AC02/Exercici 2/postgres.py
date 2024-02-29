import psycopg2
from config import load_config
import client


def insert_client(id, nom, cognom, telefon, correu, ciutat):
    """ Insert a new vendor into the vendors table """

    sql = """INSERT INTO client(id, nom, cognom, telefon, correu, ciutat)
             VALUES(%s, %s, %s, %s, %s, %s) RETURNING id;"""
    
    client_id = None
    config = load_config()

    try:
        with  psycopg2.connect(**config) as conn:
            with  conn.cursor() as cur:
                # execute the INSERT statement
                cur.execute(sql, (id, nom, cognom, telefon, correu, ciutat))

                # get the generated id back                
                rows = cur.fetchone()
                if rows:
                    client_id = rows[0]

                # commit the changes to the database
                conn.commit()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)    
    finally:
        return client_id

def add_client(id):
    """ Insert a new vendor into the vendors table """

    sql = """INSERT INTO empresa(client_id)
             VALUES(%s);"""

    config = load_config()

    try:
        with  psycopg2.connect(**config) as conn:
            with  conn.cursor() as cur:
                # execute the INSERT statement
                cur.execute(sql, (str(id)))                

                # commit the changes to the database
                conn.commit()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)    

def del_client(id):
    """ Insert a new vendor into the vendors table """

    sql = """DELETE FROM client where id = %s RETURNING id;"""

    config = load_config()

    try:
        with  psycopg2.connect(**config) as conn:
            with  conn.cursor() as cur:
                # execute the INSERT statement
                cur.execute(sql, (str(id)))                

                # commit the changes to the database
                conn.commit()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)    

def search_by_id(id):
   
    """ Retrieve data from the CLIENT table """
    config  = load_config()
    try:
        with psycopg2.connect(**config) as conn:
            with conn.cursor() as cur:
                cur.execute("SELECT id, nom, cognom, telefon, correu, ciutat FROM client")
                result_set = cur.fetchall()

                for row in result_set:
                    if row[0] == int(id):
                        return client.Client(row[0], row[1], row[2], row[3], row[4], row[5])

    except (Exception, psycopg2.DatabaseError) as error:
        print(error)


def search_by_name(nom):
   
    """ Retrieve data from the CLIENT table """
    config  = load_config()
    try:
        with psycopg2.connect(**config) as conn:
            with conn.cursor() as cur:
                cur.execute("SELECT id, nom, cognom, telefon, correu, ciutat FROM client")
                result_set = cur.fetchall()

                for row in result_set:
                    if row[1] == nom:
                        return client.Client(row[0], row[1], row[2], row[3], row[4], row[5])

    except (Exception, psycopg2.DatabaseError) as error:
        print(error)

def search_by_surename(cognom):
   
    """ Retrieve data from the CLIENT table """
    config  = load_config()
    try:
        with psycopg2.connect(**config) as conn:
            with conn.cursor() as cur:
                cur.execute("SELECT id, nom, cognom, telefon, correu, ciutat FROM client")
                result_set = cur.fetchall()

                for row in result_set:
                    if row[2] == cognom:
                        return client.Client(row[0], row[1], row[2], row[3], row[4], row[5])

    except (Exception, psycopg2.DatabaseError) as error:
        print(error)

def get_clients():
   
    """ Retrieve data from the CLIENT table """
    clients = []
    config  = load_config()
    try:
        with psycopg2.connect(**config) as conn:
            with conn.cursor() as cur:
                cur.execute("SELECT id, nom, cognom, telefon, correu, ciutat FROM client")
                result_set = cur.fetchall()

                for row in result_set:
                    clients.append(client.Client(row[0], row[1], row[2], row[3], row[4], row[5]))

                return clients
                    

    except (Exception, psycopg2.DatabaseError) as error:
        print(error)

def update_client(id, fields):
    """ Update vendor name based on the vendor id """
    
    updated_row_count = 0

    sql = """ UPDATE client
                SET nom = %s, cognom = %s, telefon = %s, 
                correu = %s, ciutat = %s
                WHERE id = %s"""
    
    config = load_config()
    
    try:
        with  psycopg2.connect(**config) as conn:
            with  conn.cursor() as cur:
                
                # execute the UPDATE statement
                cur.execute(sql, (fields["nom"], fields["cognom"], fields["telefon"], fields["correu"], fields["ciutat"], id))
                updated_row_count = cur.rowcount

            # commit the changes to the database
            conn.commit()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)    
    finally:
        return updated_row_count

