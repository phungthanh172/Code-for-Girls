from mongoengine import *
from flask import *
from werkzeug.utils import *


#Upload data to Mongo
connect('nim', host='mongodb://hiep:hiepxanh@ds015929.mlab.com:15929/nim')

class lecture(Document):
    href = StringField()
    title = StringField()
    brief = ListField(StringField())
    document = ListField(DictField())
    assignment = ListField(DictField())

lecture_list = lecture.objects

class Users(Document):
    username = StringField()
    password = StringField()

# user1 = Users(username = "dvquy",
#               password = "dvquy123")
# user2 = Users(username = "ntnhan",
#               password = "ntnhan123")
# user2.save()
# user1.save()

user_list = Users.objects
print(user_list)
app = Flask(__name__)


@app.route('/', methods=['GET', 'POST'])
def login():
    error = ""
    try:
        if request.method == "POST":
            u = request.form['username']
            p = request.form['password']
            for user in user_list:
                if user.username == u and user.password == p:
                    # session["logged_in"] = True
                    # session["username"] = request.form("username")
                    return redirect(url_for("index"))
                    # return render_template("Index.html",
                                           # username = user.username,
                    #                        lecture_list = lecture_list)
            error = "Invalid credentials. Please try again!"

    except Exception as e:
        flash(e)
        return render_template("login.html", error = error)

    return render_template('login.html', error = error)

@app.route('/<lectureHref>/')
def lectureHref(lectureHref):
    for lecture in lecture_list:
        if lecture.href == lectureHref:
            return render_template("lecture.html",
                                   lecture = lecture,
                                   lecture_list = lecture_list)
#Lay anh tai local host:
@app.route('/<path:path>/')
def static_file(path):
    return app.send_static_file(path)

@app.route('/index/')
def index():
    return render_template("Index.html",
                           lecture_list = lecture_list)



@app.errorhandler(404)
def page_not_found(e):
    return render_template("404.html")


if __name__ == '__main__':
    app.run()
