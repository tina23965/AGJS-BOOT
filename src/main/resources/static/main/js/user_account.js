//==========點修改日期時也關掉第一個彈窗===============================
$(document).on("click", "#dateUpdatedButton", () => {
  //   console.log("aaa");

  $("#close").trigger("click");
});

//===========訂單修改日期的月曆========================================
var nowDate = new Date();
var today = new Date(
  nowDate.getFullYear(),
  nowDate.getMonth(),
  nowDate.getDate(),
  0,
  0,
  0,
  0
);
$(function () {
  $('input[name="daterange"]').daterangepicker(
    {
      opens: "left",
      dateFormat: "YYYY-MM-DD",
      //從今天算起再加一天

      minDate: today,
      //三個月
    },
    function (start, end, label) {
      console.log(
        "A new date selection was made: " +
          start.format("YYYY-MM-DD") +
          " to " +
          end.format("YYYY-MM-DD")
      );
    }
  );
});

//===========訂單取消的警告，sweetalert2========================================

$(document).on("click", ".order_cancel", () => {
  Swal.fire({
    title: "確定取消此筆訂單？",
    text: "取消後若仍要入住，將需重新下訂",
    icon: "warning",
    showCancelButton: true,
    confirmButtonColor: "#d33",
    cancelButtonColor: "grey",
    confirmButtonText: "確認",
    cancelButtonText: "取消",
  }).then((result) => {
    if (result.isConfirmed) {
      Swal.fire("已取消！", "已幫您取消此筆訂單", "success");
    }
  });
});

$(document).ready(function () {
  //===========datatable_AJAX：自動抓會員的所有訂單資料========================================
  const url_3 = "order/search/byUser";
  fetch(url_3, {
    method: "POST",
    headers: {
      "Content-Type": "application/json; charset=utf-8",
    },
    body: JSON.stringify({}),
  })
    .then((response) => {
      return response.json();
    })
    .then((response) => {
      console.log(response);
      $("#order_table").DataTable({
        language: {
          url: "https://cdn.datatables.net/plug-ins/1.11.3/i18n/zh_Hant.json",
        },
        data: response,

        columns: [
          {
            data: null,
            render: function (data, type, full, meta) {
              return meta.row + 1;
            },
          },
          { data: "salesOrderHeaderId" },
          { data: "createDate" },
          { data: "salesOrderStatus" },
          {
            data: null,
            render: function (data, type, row) {
              return data.roomPrice + data.journeyPrice;
            },
          },
          {
            data: null,
            render: function (data, type, row) {
              let id = data.salesOrderHeaderId;
              return (
                '<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#' +
                id +
                '">查看詳細</button>'
              );
            },
          },
        ],
        columnDefs: [
          {
            targets: "_all",
            className: "text-center",
          },
        ],
      });
    })
    .catch((error) => {
      console.log(error);
    });

  //===========訂單明細彈窗AJAX========================================
  // const url = "user/information";
  // fetch(url, {
  //   method: "POST",
  //   headers: {
  //     "Content-Type": "application/json",
  //   },
  //   body: JSON.stringify({
  //     // userAccount: account,
  //     // userPassword: pwd,
  //   }),
  // })
  //   .then((res) => {
  //     return res.json();
  //   })
  //   .then((res) => {
  //     console.log(res);
  //     let verify = "";
  //     if (res.emailVerifyStatus === true) {
  //       verify = "已驗證";
  //     } else {
  //       verify = "未驗證";
  //     }
  //     let list_html = "";
  //     list_html += `
  //         <form action="#" data-id=${res.userId}>
  //         <br />
  //         <label>姓名</label>
  //         <input
  //           type="text"
  //           name="first-name"
  //           value=${res.userName}
  //           disabled
  //         />
  //         <label>生日</label>
  //         <input
  //           type="text"
  //           name="birthday"
  //           value=${res.userBirthday}
  //           disabled
  //         />
  //         <label>E-mail</label>
  //         <span class="mail_auth unauth"
  //           >電子郵件驗證狀態：<em class="msg">${verify}</em>
  //           <button type="button" id="sendEmail" class="mail_button">
  //             發送驗證信
  //           </button>
  //           <input type="text" class="verify_enter -none"  placeholder="驗證碼" value= "">
  //         </span>
  //         <input
  //           type="email"
  //           name="email-name"
  //           id="email-name"
  //           value=${res.userEmail}
  //         />
  //         <label>身分證字號</label>
  //         <input
  //           type="text"
  //           name="user-id"
  //           value=${res.userIdentityNumber}
  //           disabled
  //         />
  //         <label>帳號</label>
  //         <input
  //           type="text"
  //           name="user-account"
  //           value=${res.userAccount}
  //           disabled
  //         />
  //         <label>手機</label>
  //         <input
  //           type="text"
  //           name="phone"
  //           id="phone"
  //           value=${res.userPhone}
  //         />

  //         <br />
  //         <button type="button" class="btn_submit">
  //           確定修改
  //         </button>
  //       </form>
  //         `;
  //     $("#account_infor").append(list_html);
  //     if (verify === "已驗證") {
  //       $("#sendEmail").addClass("-none");
  //     }
  //   })
  //   .catch((error) => {
  //     console.log("error");
  //   });

  //===========會員資訊自動代入========================================
  const url = "user/information";
  fetch(url, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      // userAccount: account,
      // userPassword: pwd,
    }),
  })
    .then((res) => {
      return res.json();
    })
    .then((res) => {
      console.log(res);
      let verify = "";
      if (res.emailVerifyStatus === true) {
        verify = "已驗證";
      } else {
        verify = "未驗證";
      }
      let list_html = "";
      list_html += `
          <form action="#" data-id=${res.userId}>
          <br />
          <label>姓名</label>
          <input
            type="text"
            name="first-name"
            value=${res.userName}
            disabled
          />
          <label>生日</label>
          <input
            type="text"
            name="birthday"
            value=${res.userBirthday}
            disabled
          />
          <label>E-mail</label>
          <span class="mail_auth unauth"
            >電子郵件驗證狀態：<em class="msg">${verify}</em>
            <button type="button" id="sendEmail" class="mail_button">
              發送驗證信
            </button>
            <input type="text" class="verify_enter -none"  placeholder="驗證碼" value= "">
          </span>
          <input
            type="email"
            name="email-name"
            id="email-name"
            value=${res.userEmail}
          />
          <label>身分證字號</label>
          <input
            type="text"
            name="user-id"
            value=${res.userIdentityNumber}
            disabled
          />
          <label>帳號</label>
          <input
            type="text"
            name="user-account"
            value=${res.userAccount}
            disabled
          />
          <label>手機</label>
          <input
            type="text"
            name="phone"
            id="phone"
            value=${res.userPhone}
          />

          <br />
          <button type="button" class="btn_submit">
            確定修改
          </button>
        </form>
          `;
      $("#account_infor").append(list_html);
      if (verify === "已驗證") {
        $("#sendEmail").addClass("-none");
      }
    })
    .catch((error) => {
      console.log("error");
    });

  //===========驗證信箱AJAX=============================================

  $("#account_infor").on("click", "#sendEmail", () => {
    // console.log(this);
    $(".verify_enter").toggleClass("-none");
    let id = $("input[name='user-account']").val();
    let user_name = $("input[name='first-name']").val();
    let email = $.trim($("#email-name").val());
    const url_2 = "mail_verify";

    fetch(url_2, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        userAccount: id,
        userName: user_name,
        userEmail: email,
      }),
    })
      .then((res) => {
        return res.json();
      })
      .then((res) => {
        alert(res);
      })
      .catch((error) => {
        alert(error);
      });
  });

  //===========會員資訊管理========================================

  //送出
  $("#account_infor").on("click", ".btn_submit", (e) => {
    // console.log("aaa");
    e.preventDefault();
    let id = $("input[name='user-account']").val();
    let code = $.trim($(".verify_enter").val());
    let verify = $(".msg").val();
    let data_id = $("form").attr("data-id");
    let email = $.trim($("#email-name").val());
    let phone = $.trim($("#phone").val());
    let mail_reg =
      /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    let phone_reg = /^09[0-9]{8}$/;

    //信箱更新限制
    if (email == "") {
      alert("請輸入email");
      $("#email-name").focus();
      return;
    } else if (email != "" && !email.match(mail_reg)) {
      alert("請以半形輸入，並輸入正確的e-mail。");
      $("#email-name").focus();
      return;
    } else {
      $("#email-name").attr("value", email);
    }

    //信箱更新限制
    if (phone === "") {
      alert("請輸入手機");
      $("#phone").focus();
      return;
    } else if (phone != "" && !phone.match(phone_reg)) {
      alert("手機格式為09xxxxxxxx");
      $("#phone").focus();
      return;
    } else {
      $("#phone").attr("value", phone);
    }

    //===========會員資訊管理AJAX======================================

    const url = "user/information_update";
    let status = "";
    if (verify === "已驗證") {
      status = 1;
    } else {
      status = 0;
    }

    if (code === null || code === "") {
      fetch(url, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          userAccount: id,
          userEmail: email,
          userPhone: phone,
          userId: data_id,
          emailVerifyStatus: status,
        }),
      })
        .then((res) => {
          return res.json();
        })
        .then((res) => {
          if (res.verifyMsg != null) {
            alert(res.verifyMsg);
          } else if (res.errorMsg != null) {
            alert(res.errorMsg);
          } else {
            alert("更新成功");
          }
        })
        .catch((error) => {
          console.log(error);
          console.log(data_id);
        });
    } else {
      fetch(url, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          userAccount: id,
          userEmail: email,
          userPhone: phone,
          userId: data_id,
          verifyMsg: code,
          emailVerifyStatus: true,
        }),
      })
        .then((res) => {
          return res.json();
        })
        .then((res) => {
          if (res.verifyMsg != null) {
            alert(res.verifyMsg);
          } else if (res.errorMsg != null) {
            alert(res.errorMsg);
          } else {
            alert("更新成功");
          }
        })
        .catch((error) => {
          console.log(error);
          console.log(data_id);
        });
    }
  });

  //============顯示密碼====================================

  $(".pwd_read").click(function () {
    var check = $("input[class='pwd_read']:checked").length; //判斷有多少個方框被勾選
    console.log(check);
    if (check == 1) {
      $("input[class='password-txt']").attr("type", "text");
    } else {
      $("input[class='password-txt']").attr("type", "password");
    }
  });

  //===========密碼資訊管理========================================
  $(".btn_submit_2").on("click", (e) => {
    // console.log("aaa");
    e.preventDefault();
    // var check_val = true; //預設都有填

    //增加密碼的長度判斷
    let id = $("input[name='user-account']").val();
    let old_pwd = $.trim($("#old-password").val());
    let new_pwd = $.trim($("#newpassword").val());
    let check_new_pwd = $.trim($("#checkpassword").val());
    let reg = /^(?=.*[A-Z])(?=.*[a-z])(?=.*\d).{4,25}$/;
    if (old_pwd === "") {
      // check_val = false;
      $("#old_password").focus();
      alert("請填入舊密碼");
      return;
    }

    if (new_pwd === "") {
      // check_val = false;
      $("#newpassword").focus();
      alert("請填入新密碼");
      return;
    }

    if (check_new_pwd === "") {
      // check_val = false;
      $("#checkpassword").focus();
      alert("請填入密碼確認");
      return;
    }

    // --- 確認都有填值 ---
    // if (check_val == true) {
    // var double_check = true; //可送出表單
    //新密碼更新限制
    if (new_pwd != "" && !new_pwd.match(reg)) {
      double_check = false;
      alert("密碼格式需包含大小寫英文與數字，長度為4-25碼");
      $("#new_password").focus();
      return;
    }

    if (new_pwd != check_new_pwd) {
      double_check = false;
      $("#check_password").focus();
      alert("新密碼與確認密碼不符");
      return;
    }

    // if (double_check == true) {
    //   return true;
    // }
    // }
    // else {
    //   return false;
    // }

    //===========密碼資訊管理AJAX======================================

    const url = "user/password_update";

    fetch(url, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json; charset=utf-8",
      },
      body: JSON.stringify({
        userAccount: id,
        userPassword: old_pwd,
        newUserPassword: new_pwd,
      }),
    })
      .then((res) => {
        return res.json();
      })
      .then((res) => {
        if (res.errorMsg != null) {
          alert(res.errorMsg);
        } else {
          alert("更新成功");
        }

        console.log(id);
      })
      .catch((error) => {
        console.log("error");
      });
  });

  //===========登出AJAX========================================
  $("#nav-logout").on("click", () => {
    // alert("按到了");
    const url = "user/logout";
    fetch(url, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        // userAccount: account,
        // userPassword: pwd,
      }),
    }).then((res) => {
      alert("成功登出！");
      window.location.reload("user_login.html");
    });
  });
});

// --- 判斷密碼強度 ---
function checkPwStrong(pwd) {
  var strong = "";

  if (pwd.length >= 4 && pwd.length <= 6) {
    strong = 1;
  } else if (pwd.length >= 7 && pwd.length <= 14) {
    strong = 2;
  } else if (pwd.length >= 15) {
    strong = 3;
  }

  switch (strong) {
    case 1:
      $("#pwderr").html("密碼強度：弱");
      break;
    case 2:
      $("#pwderr").html("密碼強度：中");
      break;
    case 3:
      $("#pwderr").html("密碼強度：強");
      break;
  }
}
