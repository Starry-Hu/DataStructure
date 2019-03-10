function username() {
    var username = $('#username').val();
    var tips = $('#username').siblings('span');
    if (username == '') {
        $('#username').addClass('input-error');
        tips.html('用户名不能为空');
        return false;
    } else {
        $('#username').removeClass('input-error');
        tips.html('');
        return true;
    }
}

function password() {
    var password = $('#password').val();
    var tips = $('#password').siblings('span');
    if (password == '') {
        $('#password').addClass('input-error');
        tips.html('密码不能为空');
        return false;
    } else {
        $('#password').removeClass('input-error');
        tips.html('');
        return true;
    }
}

function verifyCode() {
    var verifyCode = $('#verifyCode').val();
    console.log(verifyCode);
    var tips = $('#verifyCode').siblings('span');
    if (verifyCode == '') {
        $('#verifyCode').addClass('input-error');
        tips.html('验证码不能为空');
        return false;
    } else if (verifyCode.length != 4) {
        console.log(verifyCode.length);
        $('#verifyCode').addClass('input-error');
        tips.html('验证码长度为4位');
        return false;
    } else {
        $('#verifyCode').removeClass('input-error');
        tips.html('');
        return true;
    }
}

$(function() {

    $('#username').blur(username);
    $('#password').blur(password);
    $('#verifyCode').blur(verifyCode);

    $('input').on('focus', function() {
        $(this).removeClass('input-error');
    });

    function _change() {
        var path = location.protocol + "//" + window.location.host + "/SelectCourse/VerifyCodeServlet";
        $('#verifyImg').src = path + "a=" + new Date().getTime();
    };

    function getVerifyCode() {
        var path = location.protocol + "//" + window.location.host + "/SelectCourse/VerifyCodeServlet";
        $('#verifyImg').src = path;
    }

    $('#submit').click(function(e) {
        var way = $("input[name='way']:checked").val();
        if (way == '0') {
            path = location.protocol + "//" + window.location.host + "/SelectCourse/MngLoginServlet";
        } else {
            path = location.protocol + "//" + window.location.host + "/SelectCourse/TeacherLoginServlet";
        }

        if (username() && password() && verifyCode()) {
            var formData = new FormData($("form")[0]);
            console.log(formData);
            $.ajax({
                type: "post",
                url: path,
                data: "data",
                dataType: "json",
                success: function(response) {
                    alert(response.code)
                    if (response.code == 2) {
                        $('#verifyCode').siblings('span').val('验证码错误');
                        alert(response.msg)
                    } else if (response.code == 3) {
                        alert(response.error);
                    } else if (response.code == 1) {
                        alert('登陆成功');
                        window.location = 'addStu.html';
                    }
                }
            });
        } else {
            alert('信息填写不完整！');
            e.preventDefault();
        }
    });
})