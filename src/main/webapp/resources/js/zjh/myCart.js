/**
 * Created by 29578 on 2017/5/18.
 */


function select_all(obj) {
    var isChecked = obj.checked;
    var inputs = document.getElementsByTagName("input");
    for (var i = 0; i < inputs.length; i++) {
        if (inputs[i].getAttribute("type") == "checkbox" && inputs[i] != obj) {
            if(inputs[i].checked != isChecked) {
                inputs[i].click();
                inputs[i].checked = isChecked;
            }
        }
    }
}
