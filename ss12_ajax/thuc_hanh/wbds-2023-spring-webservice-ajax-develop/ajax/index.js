function addNewSmartPhone() {
    //lấy dữ liệu từ form html
    let producer = document.getElementById("producer").value;
    let model = document.getElementById("model").value;
    let price = +document.getElementById("price").value;
    let newSmartphone = {
        "producer": producer,
        "model": model,
        "price": price,
    };
    // gọi phương thức ajax
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newSmartphone),
        //tên API
        url: "http://localhost:8080/api/smartphones",
        //xử lý khi thành công
        success: function () {
            successHandler()
        }

    });
    //chặn sự kiện mặc định của thẻ
    event.preventDefault();
}

function successHandler() {
    $.ajax({
        type: "GET",
        //tên API
        url: "http://localhost:8080/api/smartphones",
        //xử lý khi thành công
        success: function (data) {
            // hiển thị danh sách ở đây
            if (data != null || data.length > 0) {
                let content = `            <table id="display-list" border="1">
                <tr>
                    <th>Producer</th>
                    <th>Model</th>
                    <th>Price</th>
                    <th>Delete</th>
                </tr>`;
                for (let i = 0; i < data.length; i++) {
                    content += `<tr>
       
        <td>${data[i].producer}</td>
        <td>${data[i].model}</td>
        <td>${data[i].price}</td>
        <td><a href="#" onclick="deleteSmartphone(${data[i].id})">Delete</a></td>
    </tr>`;
                }
                content += "</table>"
                document.getElementById('smartphoneList').innerHTML = content;
                document.getElementById('smartphoneList').style.display = "block";
                document.getElementById('add-smartphone').style.display = "none";
                document.getElementById('display-create').style.display = "block";
                document.getElementById('title').style.display = "block";
            } else {
                document.getElementById('smartphoneList').innerHTML = "khong co du lieu";
            }

        }
    });
}

function displayFormCreate() {
    document.getElementById('smartphoneList').style.display = "none";
    document.getElementById('add-smartphone').style.display = "block";
    document.getElementById('display-create').style.display = "none";
    document.getElementById('title').style.display = "none";
}

function deleteSmartphone(id) {
    $.ajax({
        type: "DELETE",
        //tên API
        url: `http://localhost:8080/api/smartphones/${id}`,
        //xử lý khi thành công
        success: function () {
            successHandler()
        }
    });
}
