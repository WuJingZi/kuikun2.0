window.sr = ScrollReveal({ reset: true });
	var fooReveal = {
	  // 动画的时长
	    duration: 500,
	    // 延迟时间
	    delay: 500,
	    // 动画开始的位置，'bottom', 'left', 'top', 'right'
	    origin: 'top',
	    // 回滚的时候是否再次触发动画
	    reset: true,
	    // 在移动端是否使用动画
	    mobile: false,
	    // 滚动的距离，单位可以用%，rem等
	    distance: '50px',
	    // 其他可用的动画效果
	    opacity: 0.001,
	    easing: 'linear',
	    scale: 0.1
	};
	var normal = {
	  // 动画的时长
	    duration: 500,
	    // 延迟时间
	    delay: 100,
	    // 动画开始的位置，'bottom', 'left', 'top', 'right'
	    origin: 'bottom',
	    // 回滚的时候是否再次触发动画
	    reset: true,
	    // 在移动端是否使用动画
	    mobile: true,
	    // 滚动的距离，单位可以用%，rem等
	    distance: '20px',
	    // 其他可用的动画效果
	    opacity:0.8
	};
	var cube1 = {
	  // 动画的时长
	    duration: 1000,
	    // 延迟时间
	    delay: 100,
	    // 动画开始的位置，'bottom', 'left', 'top', 'right'
	    origin: 'right',
	    // 回滚的时候是否再次触发动画
	    reset: true,
	    // 在移动端是否使用动画
	    mobile: true,
	    // 滚动的距离，单位可以用%，rem等
	    distance: '280px',
	    // 其他可用的动画效果
	    opacity:0.5
	};
	var cube2 = {
	  // 动画的时长
	    duration: 1000,
	    // 延迟时间
	    delay: 100,
	    // 动画开始的位置，'bottom', 'left', 'top', 'right'
	    origin: 'bottom',
	    // 回滚的时候是否再次触发动画
	    reset: true,
	    // 在移动端是否使用动画
	    mobile: true,
	    // 滚动的距离，单位可以用%，rem等
	    distance: '180px',
	    // 其他可用的动画效果
	    opacity:0.5
	};
	var srleft = {
	  // 动画的时长
	    duration: 1000,
	    // 延迟时间
	    delay: 100,
	    // 动画开始的位置，'bottom', 'left', 'top', 'right'
	    origin: 'left',
	    // 回滚的时候是否再次触发动画
	    reset: true,
	    // 在移动端是否使用动画
	    mobile: true,
	    // 滚动的距离，单位可以用%，rem等
	    distance: '100px',
	    // 其他可用的动画效果
	    opacity:0.5
	};
	var srleftXs = {
	  // 动画的时长
	    duration: 1000,
	    // 延迟时间
	    delay: 100,
	    // 动画开始的位置，'bottom', 'left', 'top', 'right'
	    origin: 'left',
	    // 回滚的时候是否再次触发动画
	    reset: true,
	    // 在移动端是否使用动画
	    mobile: true,
	    // 滚动的距离，单位可以用%，rem等
	    distance: '30px',
	    // 其他可用的动画效果
	    opacity:0.5
	};
	var srtop = {
	  // 动画的时长
	    duration: 1000,
	    // 延迟时间
	    delay: 100,
	    // 动画开始的位置，'bottom', 'left', 'top', 'right'
	    origin: 'top',
	    // 回滚的时候是否再次触发动画
	    reset: true,
	    // 在移动端是否使用动画
	    mobile: true,
	    // 滚动的距离，单位可以用%，rem等
	    distance: '60px',
	    // 其他可用的动画效果
	    opacity:0.5
	};
	var srright = {
	  // 动画的时长
	    duration: 1000,
	    // 延迟时间
	    delay: 100,
	    // 动画开始的位置，'bottom', 'left', 'top', 'right'
	    origin: 'right',
	    // 回滚的时候是否再次触发动画
	    reset: true,
	    // 在移动端是否使用动画
	    mobile: true,
	    // 滚动的距离，单位可以用%，rem等
	    distance: '100px',
	    // 其他可用的动画效果
	    opacity:0.5
	};
	var srbottom = {
	  // 动画的时长
	    duration: 1000,
	    // 延迟时间
	    delay: 100,
	    // 动画开始的位置，'bottom', 'left', 'top', 'right'
	    origin: 'bottom',
	    // 回滚的时候是否再次触发动画
	    reset: true,
	    // 在移动端是否使用动画
	    mobile: true,
	    // 滚动的距离，单位可以用%，rem等
	    distance: '60px',
	    // 其他可用的动画效果
	    opacity:0.5
	};
	var srrightLg = {
	  // 动画的时长
	    duration: 1000,
	    // 延迟时间
	    delay: 100,
	    // 动画开始的位置，'bottom', 'left', 'top', 'right'
	    origin: 'right',
	    // 回滚的时候是否再次触发动画
	    reset: true,
	    // 在移动端是否使用动画
	    mobile: true,
	    // 滚动的距离，单位可以用%，rem等
	    distance: '260px',
	    // 其他可用的动画效果
	    opacity:0.5
	};
	var srleftLg = {
		// 动画的时长
		duration: 1000,
		// 延迟时间
		delay: 100,
		// 动画开始的位置，'bottom', 'left', 'top', 'right'
		origin: 'left',
		// 回滚的时候是否再次触发动画
		reset: true,
		// 在移动端是否使用动画
		mobile: true,
		// 滚动的距离，单位可以用%，rem等
		distance: '260px',
		// 其他可用的动画效果
		opacity:0.5
	};
	// 自定义一个动画集合
	sr.reveal( '.feature-project-list .block-rg', srrightLg );
	sr.reveal( '.feature-project-list .block-le', srleftLg );
