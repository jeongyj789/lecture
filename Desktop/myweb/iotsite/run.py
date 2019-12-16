from flask import Flask
from flask import request
from flask import render_template
from datetime import datetime
import threading
from flask import Flask, render_template, jsonify, request
import threading
import requests
import pymysql

# MySQL Connection 연결 , charset이 제대로 설정되지 않으면 한글이 깨지는 경우가 발생
conn = pymysql.connect(
    host= '13.125.236.184', 
    port= int(3306),
    user='root', 
    password='root', 
    db='test', 
    charset='utf8')
# Connection 으로부터 Cursor 생성

def sql_select():
    curs = conn.cursor()
    curs.execute('select * from test.new_table order by real_time desc;')
    data = curs.fetchall()
    # conn.close()
    curs.close()
    return data

app = Flask(__name__)
    
@app.route("/getData", methods=["GET"])
def getData():
    data = sql_select()
    return jsonify(data)

@app.route("/")
def index():
    return render_template('index2.html')

if __name__ == "__main__":
    app.run(host="0.0.0.0", debug=True, port=9000)


# @app.route('/led', methods=['GET'])
# def led():
#     a = request.args.get('input', 0, type=int)
#     if a == 0:
#         requests.get('http://210.94.181.91:8080/led/ON')
#     else :
#         requests.get('http://210.94.181.91:8080/led/OFF')
#     return 'SUCCESS'


# @app.route('/NodeMCU', methods=['GET', 'POST'])
# def test():
#     print ("NODEMCU CONNECTED!!!!!!!")
#     value = request.data.decode('utf-8')
#     print ("MESSAGE : " + value)
#     return "Connection Successed!"

# @app.route('/getAirCondition', methods=['GET'])
# def getAirCondition():
#     return requests.get('http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?sidoName=%EC%84%9C%EC%9A%B8&pageNo=1&numOfRows=10&ServiceKey=' + api_service_key + '&ver=1.3&_returnType=json').json()









# mysql = MySQL()
# #MYSQL configurations
# app.config['MYSQL_DATABASE_USER'] = 'choi'
# app.config['MYSQL_DATABASE_PASSWORD'] = 'chOicha0'
# app.config['MYSQL_DATABASE_DB'] = 'iotProject'
# app.config['MYSQL_DATABASE_HOST'] = '127.0.0.1'
# api_service_key = 'rTgkWoe%2FDfnKVsvwwiN8fT%2B6Sw7aiOMWaWH7YGczxqvnTHINnvTMv6PEHqA72S0ra3lAmKDtBhBcGxFisdD1ig%3D%3D'
# mysql.init_app(app)


# app = Flask(__name__)

# app.config["MONGO_URI"] = "mongodb://localhost:27017/myweb"
# mongo = PyMongo(app)

# @app.route("/write", methods=["GET", "POST"])
# def board_write():
#     if request.method == "POST":
#         name = request.form.get("name")
#         title = request.form.get("title")
#         contents = request.form.get("contents")
#         print(name, title, contents)

#         current_utc_time = round(datetime.utcnow().timestamp() * 1000)
#         board = mongo.db.board
#         post = {
#             "name": name,
#             "title": title,
#             "contents": contents,
#             "pubdate" : current_utc_time,
#             "view" : 0,
#         }

#         board.insert_one(post)
        
#         return ""
#     else: #GET
#         return render_template("write.html")


# # @app.route("/")
# # def index():
# #     return "<h2>헬로 파이썬</h2>"


# if __name__ == "__main__":
#     app.run(host="0.0.0.0", debug=True, port=9000)

#     # 공유기 포트 포워딩, host 입장 가능

