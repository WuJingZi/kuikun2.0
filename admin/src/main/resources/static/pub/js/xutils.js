function openx(title,url,width, height,callback) {
    layer.open({
        title: title,
        type: 2,
        area: [width, height],
        content: url,
        btn: ['确定', '取消'],
        btnAlign: 'c',
        btn1: function(index, layero){
            if(typeof callback === "function"){
                callback;
            };

        }
    });
}


function openSubmit(title,url,width, height) {
    layer.open({
        title: title,
        type: 2,
        area: [width, height],
        content: url,
        btn: ['确定', '取消'],
        btnAlign: 'c',
        btn1: function(index, layero){
            var iframeWin = layero.find('iframe')[0];
            var $=iframeWin.contentWindow.$;
            var doc=$(iframeWin.contentWindow.document);
            var sumbitForm=doc.find('#submitForm').first();
            $.ajax({
                url:$(sumbitForm).attr('action'),
                data: $(sumbitForm).serialize(),
                type:'POST',
                dataType:'json',
                success:function(result){
                if(result.success=='true'){
                    layer.close(index);
                }
                if(result.msg){
                    layer.msg(result.msg);
                }
            }});
        }
    });
}