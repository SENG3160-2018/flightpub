<%@ taglib prefix="s" uri="/struts-tags" %>

<header class="bg-dark shadow fixed-top">
    <div class="container">
        <nav class="navbar navbar-expand-lg navbar-inverse">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar" aria-controls="navbar" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbar">
                <a class="navbar-brand" href="/">FlightPub</a>
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="#">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Privacy</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Contact</a>
                    </li>
                </ul>
                <div class="dropdown">
                    <a class="btn btn-dark dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Change User
                    </a>

                    <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                        <a class="dropdown-item" href="<s:url action='search' >
                        <s:param name='userType'>business</s:param>
                    </s:url>">Business</a>
                        <a class="dropdown-item" href="<s:url action='search' >
                        <s:param name='userType'>couple</s:param>
                    </s:url>">Couple</a>
                        <a class="dropdown-item" href="<s:url action='search' >
                        <s:param name='userType'>group</s:param>
                    </s:url>">Group</a>
                    </div>
                </div>
                <div class="cart">
                    <s:if test="%{!#session.CART.isEmpty}">
                        <a class="cart-link" href="<s:url action='checkout'></s:url>">
                            <i class="fas fa-shopping-cart"></i>
                            <span class="cart-badge"></span>
                        </a>
                    </s:if>
                    <s:else>
                        <i class="fas fa-shopping-cart"></i>
                    </s:else>
                </div>
            </div>
        </nav>
    </div>
</header>