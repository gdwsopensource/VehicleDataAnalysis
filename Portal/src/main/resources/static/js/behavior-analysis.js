(function(){
	var dom = document.getElementById('behavior-analysis');
	var myChart = echarts.init(dom);

	var option = null;
option = {
     tooltip: {
        trigger: 'axis'
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis: {
        type: 'category',
        boundaryGap: false,
        data: ['00:00', '06:15',  '12:30', '18:45', '20:00', '21:15',  '23:45'],
        axisLine:{
            lineStyle:{
                'color':'#227eda',
            }
        }
    },
    yAxis: {
        type: 'value',
         axisLine:{
            lineStyle:{
                'color':'#227eda',
            }
        },splitLine: {
            show: false
        }
    },
    series: [
        {
            name:'邮件营销',
            type:'line',
            stack: '总量',
            data:[120, 101, 134, 90, 230, 210,132],
            symbol:'circle',
            itemStyle:{
                normal:{
                    color:'#227eda'
                }
            },
            lineStyle:{
                normal:{
                    color:'#227eda'
                }
            },
            areaStyle: {
                normal: {
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        offset: 0,
                        color: '#1b598b'
                    }, {
                        offset: 1,
                        color: '#173652'
                    }])
                }
            }
        }
       
    ]
};
if (option && typeof option === 'object') {
    myChart.setOption(option, true);
}
})();
