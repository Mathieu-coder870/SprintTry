package fr.simplon.domedespuys.views;

public class PurchaseView {




        public interface Id {}
        public interface Number {}
        public interface CreatedAt {}
        public interface Status {}
        public interface User {}
        public interface Address {}

        public interface PurchaseListView extends CreatedAt, Number, Status {}
        public interface PurchaseDetailView extends
                PurchaseListView,
                User,
                UserView.UserListView,
                Address
        {}

}
