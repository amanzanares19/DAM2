import psycopg2
from config import load_config


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
                print("The number of parts: ", cur.rowcount)
                result_set = cur.fetchall()

                for row in result_set:
                    if row[0] == int(id):
                        return row

    except (Exception, psycopg2.DatabaseError) as error:
        print(error)
